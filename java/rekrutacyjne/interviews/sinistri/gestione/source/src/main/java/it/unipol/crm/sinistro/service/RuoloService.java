package it.unipol.crm.sinistro.service;

import it.unipol.crm.sinistro.config.ModelMapper;
import it.unipol.crm.sinistro.exception.WrongInputObjectException;
import it.unipol.crm.sinistro.model.ruolo.RuoloSinistro;
import it.unipol.crm.sinistro.persistence.entity.claimrole.UplCrmClaimRole;
import it.unipol.crm.sinistro.persistence.entity.claimrole.UplCrmClaimRoleRepository;
import it.unipol.crm.sinistro.persistence.service.UplCrmClaimRolePersistenceService;
import it.unipol.crm.sinistro.util.UserUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigInteger;

@Slf4j
@Service
public class RuoloService {
    @Autowired
    ModelMapper modelMapper;

    @Autowired
    private UplCrmClaimRoleRepository claimRoleRepository;
    @Autowired
    private UplCrmClaimRolePersistenceService claimRolePersistenceService;
    @Autowired
    private UserUtil userUtil;

    @Transactional
    public UplCrmClaimRole addRuolo(RuoloSinistro inputObject, BigInteger claimId, String xUnipolRequestid, String userNameCalculated, String xUnipolApplication) {

        if (inputObject == null ) {
            throw new WrongInputObjectException("Input object is null", xUnipolRequestid);
        }

        if (inputObject.getContattoId() == null) {
            final String message = "At least one of the following not-null fields in input object is null: " +
                    "contattoId = " + inputObject.getContattoId();
            throw new WrongInputObjectException(message, xUnipolRequestid);
        }

        if (claimRoleRepository.findContactId(inputObject.getContattoId()) == null) {
            final String message = "Contact with given Id doesn't exists. Id: contattoId = " + inputObject.getContattoId();
            throw new WrongInputObjectException(message, xUnipolRequestid);
        }

        final var toCreate = modelMapper.convertRuoloSinistroToUplCrmClaimRole(inputObject);
        toCreate.setLastUpdateUser(userNameCalculated);
        toCreate.setClaimId(claimId);
        return claimRolePersistenceService.insertClaimRole(toCreate);
    }
}
