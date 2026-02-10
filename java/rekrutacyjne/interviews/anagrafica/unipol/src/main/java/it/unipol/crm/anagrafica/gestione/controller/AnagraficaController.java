package it.unipol.crm.anagrafica.gestione.controller;

import it.unipol.crm.anagrafica.gestione.config.ControllerHeaders;
import it.unipol.crm.anagrafica.gestione.model.AnagraficaResponse;
import it.unipol.crm.anagrafica.gestione.service.AnagraficaService;
import it.unipol.crm.anagrafica.gestione.util.HeaderParameters;
import it.unipol.crm.anagrafica.gestione.model.definitions.CreaAnagraficaRequest;
import it.unipol.crm.anagrafica.gestione.model.definitions.UpdateAnagraficaRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.math.BigInteger;

@RestController
@RequestMapping(path = "/api/crm/anagrafica/v1/anagrafica", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
@Slf4j
public class AnagraficaController {
    @Autowired
    private AnagraficaService anagraficaService;

    @PostMapping("")
    public ResponseEntity<AnagraficaResponse> insertAnagrafica(
            Authentication authentication,
            @RequestHeader(value = ControllerHeaders.X_UNIPOL_REQUESTID) String xUnipolRequestId,
            @RequestHeader(value = ControllerHeaders.X_UNIPOL_APPLICATION) String xUnipolApplication,
            @NotBlank @RequestBody CreaAnagraficaRequest anagrafica){

        log.debug("Request: " + anagrafica);
        AnagraficaResponse response = anagraficaService.insertAnagrafica(authentication.getName(),checkIfAnagraficaWasPassed(anagrafica),populateHeaders(xUnipolRequestId,xUnipolApplication));
        return ResponseEntity.ok().body(response);
    }

    @PutMapping("/{idSoggetto}")
    public ResponseEntity<AnagraficaResponse> updateAnagrafica (
            Authentication authentication,
            @RequestHeader(value = ControllerHeaders.X_UNIPOL_REQUESTID) String xUnipolRequestId,
            @RequestHeader(value = ControllerHeaders.X_UNIPOL_APPLICATION) String xUnipolApplication,
            @NotBlank @PathVariable BigInteger idSoggetto,
            @NotBlank @RequestBody UpdateAnagraficaRequest anagrafica) {

        AnagraficaResponse response = anagraficaService.updateAnagrafica(authentication.getName(),idSoggetto,checkIfAnagraficaWasPassed(anagrafica),populateHeaders(xUnipolRequestId,xUnipolApplication));

        return ResponseEntity.ok().body(response);
    }
    private HeaderParameters populateHeaders(String xUnipolRequestId,String xUnipolApplication){
        HeaderParameters headers = new HeaderParameters();
        headers.setApplicationId(xUnipolApplication);
        headers.setRequestId(xUnipolRequestId);
        if(xUnipolRequestId == null || xUnipolApplication == null){
            throw new IllegalArgumentException("X-UNIPOL-REQUESTID and xUnipolApplication header parameters must be passed in request!");
        }
        return headers;
    }
    private CreaAnagraficaRequest checkIfAnagraficaWasPassed(CreaAnagraficaRequest anagrafica){

        if(anagrafica == null){
            throw new IllegalArgumentException("anagrafica request body must be passed in request!");
        }
        return anagrafica;
    }
    private UpdateAnagraficaRequest checkIfAnagraficaWasPassed(UpdateAnagraficaRequest anagrafica){

        if(anagrafica == null){
            throw new IllegalArgumentException("anagrafica request body must be passed in request!");
        }
        return anagrafica;
    }
}
