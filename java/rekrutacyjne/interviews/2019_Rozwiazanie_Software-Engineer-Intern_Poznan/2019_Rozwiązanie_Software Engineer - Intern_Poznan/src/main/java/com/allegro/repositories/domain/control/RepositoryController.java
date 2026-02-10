package com.allegro.repositories.domain.control;

import com.allegro.repositories.domain.entity.RepositoryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(RepositoryController.RESOURCE_PATH)
public class RepositoryController {

    public static final String RESOURCE_PATH = "/api/repositories";
    private static final String COMPANY = "/{company}";

    private final RepositoryService repositoryService;

    @Autowired
    public RepositoryController(RepositoryService repositoryService) {
        this.repositoryService = repositoryService;
    }

    @GetMapping(COMPANY)
    public ResponseEntity getLastUpdatedRepositoryOfCompany(@PathVariable String company) {
        return repositoryService.getLastUpdatedRepositoryOfCompany(company)
                .map(this::buildOkResponse)
                .orElseGet(this::buildNotFoundResponse);
    }

    private ResponseEntity buildOkResponse(RepositoryEntity repositoryEntity) {
        return new ResponseEntity<>(repositoryEntity.getName(), HttpStatus.OK);
    }

    private ResponseEntity buildNotFoundResponse() {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}