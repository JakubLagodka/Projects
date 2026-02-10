package it.unipol.crm.sinistro.service;

import it.unipol.crm.sinistro.config.ModelMapper;
import it.unipol.crm.sinistro.exception.WrongInputObjectException;
import it.unipol.crm.sinistro.model.Paginazione;
import it.unipol.crm.sinistro.model.sinistro.Sinistro;
import it.unipol.crm.sinistro.model.sinistro.SinistroPaginatoRisp;
import it.unipol.crm.sinistro.model.sinistro.SinistroRisp;
import it.unipol.crm.sinistro.persistence.entity.claim.UplCrmClaim;
import it.unipol.crm.sinistro.persistence.entity.claim.UplCrmClaimRepository;
import it.unipol.crm.sinistro.persistence.entity.claimcontract.UplCrmClaimContract;
import it.unipol.crm.sinistro.persistence.entity.claimcontract.UplCrmClaimContractRepository;
import it.unipol.crm.sinistro.persistence.entity.claimrole.UplCrmClaimRole;
import it.unipol.crm.sinistro.persistence.entity.claimrole.UplCrmClaimRoleRepository;
import it.unipol.crm.sinistro.persistence.service.UplCrmClaimPersistenceService;
import it.unipol.crm.sinistro.util.UserUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class SinistroService {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    private UplCrmClaimRepository claimRepository;

    @Autowired
    private UplCrmClaimContractRepository claimContractRepository;

    @Autowired
    private UplCrmClaimRoleRepository claimRoleRepository;
    @Autowired
    private UplCrmClaimPersistenceService claimPersistenceService;
    @Autowired
    private ContrattoService contrattoService;
    @Autowired
    private RuoloService ruoloService;
    @Autowired
    private UserUtil userUtil;

    @Transactional
    public SinistroRisp getSinistro(BigInteger sinistroId) {

        if (sinistroId == null) {
            log.warn("No sinistro id provided.");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Given sinistroId is null");
        }

        final Optional<UplCrmClaim> claimOptional = claimRepository.findById(sinistroId);

        if (claimOptional.isEmpty()) {
            log.warn("sinistro with sinistroId {} is not found", sinistroId);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "sinistro with sinistroId "+ sinistroId +" is not found");
        }

        final UplCrmClaimContract claimContract = claimContractRepository.findByClaimId(sinistroId);
        final List<UplCrmClaimRole> claimRoles = claimRoleRepository.findByClaimId(sinistroId);

        return modelMapper.convertUplCrmClaimToFullSinistroRisp(claimOptional.get(), claimContract, claimRoles);
    }

    public SinistroPaginatoRisp getSinistri(BigInteger contattoId, Integer pagina, Integer risultatiPerPagina, LocalDate dataDenunciaDa,
                                            LocalDate dataDenunciaA, String chiaveSinistro, BigInteger contrattoId) {

        if (contattoId == null) {
            log.warn("No contattoId provided");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No contattoId provided.");
        }

        pagina = pagina == null ? 0 : pagina;
        risultatiPerPagina = risultatiPerPagina == null ? 20 : risultatiPerPagina;
        Pageable pageable = PageRequest.of(pagina, risultatiPerPagina);

        Timestamp reportedDtStart = dataDenunciaDa == null ? null : Timestamp.valueOf(dataDenunciaDa.atStartOfDay());
        Timestamp reportedDtEnd = dataDenunciaA == null ? null : Timestamp.valueOf(dataDenunciaA.atStartOfDay());

        List<UplCrmClaim> claims = claimRepository.findAllByAdminRefNumAndContattoIdAndContrattoIdAndReportedDtBetween
                (chiaveSinistro, contattoId, contrattoId, reportedDtStart, reportedDtEnd, pageable);

        if (claims.isEmpty()) {
            log.warn("no sinistri found");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "no sinistri found");
        }

        List<SinistroRisp> sinistroRispList = claims.stream()
                .map(c -> modelMapper.convertUplCrmClaimToFullSinistroRisp(c,
                        claimContractRepository.findByClaimId(c.getClaimId()),
                        claimRoleRepository.findByClaimId(c.getClaimId())))
                .collect(Collectors.toList());

        var paginazione = new Paginazione(BigInteger.valueOf(sinistroRispList.size()), risultatiPerPagina, pagina);

        return new SinistroPaginatoRisp(paginazione, sinistroRispList);
    }

    @Transactional
    public SinistroRisp addSinistro(Sinistro inputObject, String xUnipolRequestid, String userName, String xUnipolApplication) {

        if (inputObject == null ) {
            throw new WrongInputObjectException("Input object is null", xUnipolRequestid);
        }

        if (inputObject.getRamo() == null) {
            final String message = "At least one of the following not-null fields in input object is null: " +
                    "ramo = " + inputObject.getRamo();
            throw new WrongInputObjectException(message, xUnipolRequestid);
        }

        String userNameCalculated = userUtil.calculateUpdateUser(userName, xUnipolApplication);

        final var toCreate = modelMapper.convertSinistroToUplCrmClaim(inputObject);
        toCreate.setLastUpdateUser(userNameCalculated);
        final UplCrmClaim created = claimPersistenceService.insertClaim(toCreate);
        BigInteger claimId = created.getClaimId();

        UplCrmClaimContract claimContract = inputObject.getContrattoAssociato() == null ? null :
                contrattoService.addContratto(inputObject.getContrattoAssociato(),
                claimId, xUnipolRequestid, userNameCalculated, xUnipolApplication);

        List<UplCrmClaimRole> claimRoles = inputObject.getRuoli() == null ? null :
                inputObject.getRuoli().stream()
                        .map(r -> ruoloService.addRuolo(r, claimId, xUnipolRequestid, userNameCalculated, xUnipolApplication))
                        .collect(Collectors.toList());

        return modelMapper.convertUplCrmClaimToFullSinistroRisp(created, claimContract, claimRoles);
    }
}