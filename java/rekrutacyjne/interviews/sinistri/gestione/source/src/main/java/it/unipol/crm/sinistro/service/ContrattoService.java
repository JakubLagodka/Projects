package it.unipol.crm.sinistro.service;

import it.unipol.crm.sinistro.config.ModelMapper;
import it.unipol.crm.sinistro.exception.WrongInputObjectException;
import it.unipol.crm.sinistro.model.contratto.ContrattoAssociato;
import it.unipol.crm.sinistro.persistence.entity.claimcontract.UplCrmClaimContract;
import it.unipol.crm.sinistro.persistence.entity.claimcontract.UplCrmClaimContractRepository;
import it.unipol.crm.sinistro.persistence.service.UplCrmClaimContractPersistenceService;
import it.unipol.crm.sinistro.util.UserUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigInteger;

@Slf4j
@Service
public class ContrattoService {
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    private UplCrmClaimContractRepository claimContractRepository;
    @Autowired
    private UplCrmClaimContractPersistenceService claimContractPersistenceService;
    @Autowired
    private UserUtil userUtil;

    @Transactional
    public UplCrmClaimContract addContratto(ContrattoAssociato inputObject, BigInteger claimId, String xUnipolRequestid, String userNameCalculated, String xUnipolApplication) {

        if (inputObject == null) {
            throw new WrongInputObjectException("Input object is null", xUnipolRequestid);
        }

        if (inputObject.getContrattoId() == null) {
            final String message = "At least one of the following not-null fields in input object is null: " +
                    "contrattoId = " + inputObject.getContrattoId();
            throw new WrongInputObjectException(message, xUnipolRequestid);
        }

        if (claimContractRepository.findContractId(inputObject.getContrattoId()) == null) {
            final String message = "Contract with given Id doesn't exists. Id: contrattoId = " + inputObject.getContrattoId();
            throw new WrongInputObjectException(message, xUnipolRequestid);
        }

        final var toCreate = modelMapper.convertContrattoAssociatoToUplCrmClaimContract(inputObject);
        toCreate.setLastUpdateUser(userNameCalculated);
        toCreate.setClaimId(claimId);
        return claimContractPersistenceService.insertClaimContract(toCreate);
    }
}