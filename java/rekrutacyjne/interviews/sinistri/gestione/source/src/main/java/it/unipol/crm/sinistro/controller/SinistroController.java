package it.unipol.crm.sinistro.controller;

import io.swagger.annotations.ApiImplicitParam;
import it.unipol.crm.sinistro.config.Constants;
import it.unipol.crm.sinistro.model.sinistro.Sinistro;
import it.unipol.crm.sinistro.model.sinistro.SinistroPaginatoRisp;
import it.unipol.crm.sinistro.model.sinistro.SinistroRisp;
import it.unipol.crm.sinistro.service.SinistroService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigInteger;
import java.time.LocalDate;

@Slf4j
@Controller
@RequestMapping(path = "/api/sinistri/v1", produces = MediaType.APPLICATION_JSON_VALUE)
public class SinistroController {

    @Autowired
    private SinistroService service;

    @ApiImplicitParam(name = "Authorization", value = "Access Token", required = true, paramType = "header", dataTypeClass = String.class, example = "Bearer access_token")
    @GetMapping("{sinistroId}")
    public ResponseEntity<SinistroRisp> getSinistro(
            Authentication authentication,
            @PathVariable("sinistroId") @Valid BigInteger sinistroId,
            @RequestHeader(value = "X-UNIPOL-REQUESTID") String xUnipolRequestId,
            @RequestHeader(value = "X-UNIPOL-APPLICATION") String xUnipolApplication
    ) {

        log.info("Returning sinistro with id {}", sinistroId);

        SinistroRisp response = service.getSinistro(sinistroId);

        log.debug("Sinistro response {}", response);
        return ResponseEntity.ok().body(response);
    }

    @ApiImplicitParam(name = "Authorization", value = "Access Token", required = true, paramType = "header", dataTypeClass = String.class, example = "Bearer access_token")
    @GetMapping
    public ResponseEntity<SinistroPaginatoRisp> getSinistri(
            Authentication authentication,
            @RequestHeader(value = "X-UNIPOL-REQUESTID") String xUnipolRequestId,
            @RequestHeader(value = "X-UNIPOL-APPLICATION") String xUnipolApplication,
            @RequestParam(value = "contattoId") @Valid BigInteger contattoId,
            @RequestParam(value = "pagina", required = false) @Valid Integer pagina,
            @RequestParam(value = "risultatiPerPagina", required = false) @Valid Integer risultatiPerPagina,
            @RequestParam(value = "dataDenunciaDa", required = false) @DateTimeFormat(pattern = Constants.INPUT_DATE_FORMAT) @Valid LocalDate dataDenunciaDa,
            @RequestParam(value = "dataDenunciaA", required = false) @DateTimeFormat(pattern = Constants.INPUT_DATE_FORMAT) @Valid LocalDate dataDenunciaA,
            @RequestParam(value = "chiaveSinistro", required = false) String chiaveSinistro,
            @RequestParam(value = "contrattoId", required = false) @Valid BigInteger contrattoId
    ) {

        log.info("Returning sinistri with chiaveSinistro {} in date period {} - {}", chiaveSinistro, dataDenunciaDa, dataDenunciaA);

        SinistroPaginatoRisp response = service.getSinistri(contattoId, pagina, risultatiPerPagina,
                dataDenunciaDa, dataDenunciaA, chiaveSinistro, contrattoId);

        log.debug("Sinistri response {}", response);
        return ResponseEntity.ok().body(response);
    }

    @ApiImplicitParam(name = "Authorization", value = "Access Token", required = true, paramType = "header", dataTypeClass = String.class, example = "Bearer access_token")
    @PostMapping
    public ResponseEntity<SinistroRisp> addSinistro(
            Authentication authentication,
            @RequestBody Sinistro request,
            @RequestHeader(value = "X-UNIPOL-REQUESTID") String xUnipolRequestId,
            @RequestHeader(value = "X-UNIPOL-APPLICATION") String xUnipolApplication
    ) {

        log.info("Adding new sinistro with request {}", request);

        SinistroRisp response = service.addSinistro(request, xUnipolRequestId, authentication.getName(), xUnipolApplication);

        log.debug("Returning new sinistro {}", response);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}