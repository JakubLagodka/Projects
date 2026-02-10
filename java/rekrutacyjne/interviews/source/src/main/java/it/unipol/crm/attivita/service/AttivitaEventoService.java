package it.unipol.crm.attivita.service;

import it.unipol.crm.attivita.enums.OperationType;
import it.unipol.crm.attivita.persistence.model.Attivita;
import it.unipol.crm.attivita.model.McEventi;
import it.unipol.crm.attivita.model.UpdateAttivitaEventoRequest;
import it.unipol.crm.attivita.model.UpdateAttivitaEventoResponse;
import it.unipol.crm.attivita.persistence.exceptions.NuovaAttivitaException;
import it.unipol.crm.attivita.persistence.exceptions.NuovaAttivitaValidationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;

import javax.naming.OperationNotSupportedException;
import javax.transaction.Transactional;
import java.math.BigInteger;

@Slf4j
@Service
public class AttivitaEventoService {

    @Autowired
    private AttivitaService attivitaService;

    @Autowired
    private McEventiService mcEventiService;

    @Transactional
    public UpdateAttivitaEventoResponse processAttivitaEvento(UpdateAttivitaEventoRequest request, String userName, String xUnipolApplication, Jwt token) throws NuovaAttivitaValidationException, NuovaAttivitaException, OperationNotSupportedException {

        log.info("AttivitaEventoService.updateAttivitaEvento request object: {}", request);

        if (!(isAttivitaCorrect(request) && isEventoCorrect(request))) {
            log.warn("Not valid input object.");
            throw new IllegalArgumentException("Not valid input object.");
        }

        // insert/update/delete attivita
        Attivita attivita = null;
        McEventi mcEventi = null;
        switch (request.getAttivitaOperationType()) {
            case INSERT: {
                attivita = attivitaService.addAttivita(request.getNuovaAttivita(), userName, xUnipolApplication, token.getTokenValue()).get(0);
                if (attivita.getId() == null) {
                    throw new OperationNotSupportedException("Inserted or updated attivita object doesn't contain id field.");
                }
                break;
            }
            case UPDATE: {
                attivita = attivitaService.updateAttivita(request.getAttivita(), userName, xUnipolApplication);
                if (attivita.getId() == null) {
                    throw new OperationNotSupportedException("Inserted or updated attivita object doesn't contain id field.");
                }
                break;
            }
            case DELETE: {
                attivitaService.deleteAttivita(BigInteger.valueOf(request.getAttivita().getId()));
                break;
            }
        }

        // insert/delete mcEventi
        McEventi mcEventiFromRequest = request.getMcEventi();
        if (request.getAttivitaOperationType() != OperationType.DELETE && attivita != null) {
                mcEventiFromRequest.setIdAttivita(BigInteger.valueOf(attivita.getId()));
        }
        mcEventi = processMcEventi(mcEventiFromRequest, request.getEventiOperationType());

        return UpdateAttivitaEventoResponse.builder()
                .attivitaOperationType(request.getAttivitaOperationType())
                .eventiOperationType(request.getEventiOperationType())
                .attivita(attivita)
                .mcEventi(mcEventi)
                .build();
    }

    private McEventi processMcEventi(McEventi mcEventi, OperationType operationType) throws OperationNotSupportedException {

        McEventi objToReturn = null;

        switch (operationType) {
            case INSERT: {
                objToReturn = mcEventiService.insertMcEventi(mcEventi);
                break;
            }
            case UPDATE: {
                log.warn("Update McEventi is not supported.");
                throw new OperationNotSupportedException("Update McEventi is not supported.");
            }
            case DELETE: {
                mcEventiService.deleteMcEventi(mcEventi);
                break;
            }
        }

        return objToReturn;
    }

    private boolean isAttivitaCorrect(UpdateAttivitaEventoRequest request) {

        final boolean generalCondition = request.getAttivitaOperationType() != null;
        final boolean validForInsert = request.getAttivitaOperationType() == OperationType.INSERT && request.getNuovaAttivita() != null;
        final boolean validForUpdateOrDelete = (request.getAttivitaOperationType() == OperationType.UPDATE || request.getAttivitaOperationType() ==  OperationType.DELETE) &&
                request.getAttivita() != null;

        return generalCondition && validForInsert || generalCondition && validForUpdateOrDelete;
    }

    private boolean isEventoCorrect(UpdateAttivitaEventoRequest request) {

        return request.getEventiOperationType() != null && request.getMcEventi() != null;
    }
}
