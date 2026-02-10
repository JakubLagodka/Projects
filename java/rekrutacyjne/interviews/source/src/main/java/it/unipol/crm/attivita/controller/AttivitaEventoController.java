package it.unipol.crm.attivita.controller;

import io.swagger.annotations.ApiImplicitParam;
import it.unipol.crm.attivita.model.UpdateAttivitaEventoRequest;
import it.unipol.crm.attivita.model.UpdateAttivitaEventoResponse;
import it.unipol.crm.attivita.persistence.exceptions.NuovaAttivitaException;
import it.unipol.crm.attivita.persistence.exceptions.NuovaAttivitaValidationException;
import it.unipol.crm.attivita.service.AttivitaEventoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.naming.OperationNotSupportedException;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.NoSuchElementException;

@Slf4j
@Controller
@RequestMapping("/api/v1")
public class AttivitaEventoController {

    @Autowired
    private AttivitaEventoService service;

    @ApiImplicitParam(name = "Authorization", value = "Access Token", required = true, allowEmptyValue = false, paramType = "header", dataTypeClass = String.class, example = "Bearer access_token")
    @PutMapping(path = "/updateAttivitaEvento", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UpdateAttivitaEventoResponse> updateAttivitaEvento(
            Authentication authentication,
            @RequestBody UpdateAttivitaEventoRequest request,
            @RequestHeader(value = "Date", required = true) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date requestDate,
            @RequestHeader(value = "X-UNIPOL-REQUESTID", required = true) String xUnipolRequestId,
            @RequestHeader(value = "X-UNIPOL-APPLICATION", required = true) String xUnipolApplication,
            @AuthenticationPrincipal Jwt token
    ) throws URISyntaxException {

        log.info("Updating Attivita and McEventi with request {}", request);

        if (request == null) {
            log.warn("Null object in request.");
            return ResponseEntity.badRequest().build();
        }

        try {
            final UpdateAttivitaEventoResponse response = service.processAttivitaEvento(request, authentication.getName(), xUnipolApplication, token);

            log.debug("Processed Attivita and McEventi: {}", response);
            return ResponseEntity.ok(response);

        } catch (NoSuchElementException e) {
            log.warn("Attivita or McEventi not found, {}", request);
            return ResponseEntity.notFound().build();
        } catch (NuovaAttivitaValidationException e) {
            log.warn("Validation exception for NuovaAttivita, {}", request);
            return ResponseEntity.badRequest().build();
        } catch (NuovaAttivitaException e) {
            log.warn("NuovaAttivitaException, {}", request);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        } catch (OperationNotSupportedException e) {
            log.warn("Update McEventi is not supported., {}", request);
            return ResponseEntity.badRequest().build();
        }
    }
}
