package it.unipol.crm.attivita.controller;

import io.swagger.annotations.ApiImplicitParam;
import it.unipol.crm.attivita.model.InsertAttivitaWithConfigResponse;
import it.unipol.crm.attivita.persistence.exceptions.NuovaAttivitaException;
import it.unipol.crm.attivita.persistence.exceptions.NuovaAttivitaValidationException;
import it.unipol.crm.attivita.persistence.model.Attivita;
import it.unipol.crm.attivita.persistence.model.NuovaAttivita;
import it.unipol.crm.attivita.service.AttivitaService;
import it.unipol.crm.attivita.service.McEventiService;
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

import javax.validation.Valid;
import java.math.BigInteger;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Slf4j
@Controller
@RequestMapping("/api/v1")
public class AttivitaController {

    @Autowired
    private AttivitaService service;

    @Autowired
    private McEventiService mcEventiService;

    @ApiImplicitParam(name = "Authorization", value = "Access Token", required = true, allowEmptyValue = false, paramType = "header", dataTypeClass = String.class, example = "Bearer access_token")
    @GetMapping(path = "/attivita/{attivitaId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Attivita> getAttivita(
            @PathVariable(value = "attivitaId") @Valid BigInteger attivitaId,
            @RequestHeader(value = "Date", required = true) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date requestDate,
            @RequestHeader(value = "X-UNIPOL-REQUESTID", required = true) String xUnipolRequestId,
            @RequestHeader(value = "X-UNIPOL-APPLICATION", required = true) String xUnipolApplication
    ){
        log.info("Returning attivita with id {}", attivitaId);
        if(attivitaId == null){
            log.warn("No attivita id provided.");
            return ResponseEntity.badRequest().build();
        }

        Optional<Attivita> response = service.getAttivita(attivitaId);

        if(response.isEmpty()){
            log.warn("Attivita with id {} not found.", attivitaId);
            return ResponseEntity.notFound().build();
        }

        log.debug("Attivita response {}", response);
        return ResponseEntity.ok().body(response.get());
    }

    @ApiImplicitParam(name = "Authorization", value = "Access Token", required = true, allowEmptyValue = false, paramType = "header", dataTypeClass = String.class, example = "Bearer access_token")
    @PostMapping(path = "/attivita", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<InsertAttivitaWithConfigResponse> addAttivita(
            Authentication authentication,
            @RequestBody NuovaAttivita request,
            @RequestHeader(value = "Date", required = true) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date requestDate,
            @RequestHeader(value = "X-UNIPOL-REQUESTID", required = true) String xUnipolRequestId,
            @RequestHeader(value = "X-UNIPOL-APPLICATION", required = true) String xUnipolApplication,
            @AuthenticationPrincipal Jwt token
    ) throws NuovaAttivitaException, NuovaAttivitaValidationException, URISyntaxException {
        log.info("Adding new attivita with request {}", request);

        List<Attivita> attivitaList = service.addAttivita(request, authentication.getName(), xUnipolApplication, token.getTokenValue());

        InsertAttivitaWithConfigResponse response = new InsertAttivitaWithConfigResponse();
        response.setAttivitaList(attivitaList);

        log.debug("Returning add attivita response {}", response);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @ApiImplicitParam(name = "Authorization", value = "Access Token", required = true, allowEmptyValue = false, paramType = "header", dataTypeClass = String.class, example = "Bearer access_token")
    @PutMapping(path = "/attivita", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Attivita> updateAttivita(
            Authentication authentication,
            @RequestBody Attivita request,
            @RequestHeader(value = "Date", required = true) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date requestDate,
            @RequestHeader(value = "X-UNIPOL-REQUESTID", required = true) String xUnipolRequestId,
            @RequestHeader(value = "X-UNIPOL-APPLICATION", required = true) String xUnipolApplication
    ){
        log.info("Updating attivita with request {}", request);

        if (request.getId() == null) {
            log.warn("Null attivita id to update.");
            return ResponseEntity.badRequest().build();
        }

        try {
            Attivita response = service.updateAttivita(request, authentication.getName(), xUnipolApplication);

            log.debug("Updated attivita {}", response);
            return ResponseEntity.ok(response);

        }catch (NoSuchElementException e){
            log.warn("Attivita to update not found, {}", request);
            return ResponseEntity.notFound().build();
        }
    }

    @ApiImplicitParam(name = "Authorization", value = "Access Token", required = true, allowEmptyValue = false, paramType = "header", dataTypeClass = String.class, example = "Bearer access_token")
    @DeleteMapping(path = "/attivita/{attivitaId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Attivita> deleteAttivita(
            @PathVariable(value = "attivitaId") @Valid BigInteger attivitaId,
            @RequestHeader(value = "Date", required = true) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date requestDate,
            @RequestHeader(value = "X-UNIPOL-REQUESTID", required = true) String xUnipolRequestId,
            @RequestHeader(value = "X-UNIPOL-APPLICATION", required = true) String xUnipolApplication
    ){

        if(attivitaId == null){
            log.warn("No attivita id provided.");
            return ResponseEntity.badRequest().build();
        }

        log.info("Deleting attivita with id {}", attivitaId);

        final Attivita deleted = service.deleteAttivita(attivitaId);

        return ResponseEntity.ok(deleted);
    }
}
