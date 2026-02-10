package com.allegro.repositories.domain.control;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import com.allegro.repositories.domain.entity.RepositoryEntity;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.apache.http.client.utils.URIBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.allegro.repositories.domain.model.PathModel.API_GITHUB_COM;
import static com.allegro.repositories.domain.model.PathModel.HTTPS;
import static com.allegro.repositories.domain.model.PathModel.ORGS;
import static com.allegro.repositories.domain.model.PathModel.PUBLIC;
import static com.allegro.repositories.domain.model.PathModel.REPOS;
import static com.allegro.repositories.domain.model.PathModel.SLASH;
import static com.allegro.repositories.domain.model.PathModel.SORT;
import static com.allegro.repositories.domain.model.PathModel.TYPE;
import static com.allegro.repositories.domain.model.PathModel.UPDATED;
import static com.allegro.repositories.domain.model.RepositoryModel.ERROR_WHILE_GETTING_LIST_OF_REPOSITORY_ENTITIES_ERROR_MESSAGE;
import static com.allegro.repositories.domain.model.RepositoryModel.ERROR_WHILE_GETTING_REPOSITORIES_FROM_URL_ERROR_MESSAGE;
import static com.allegro.repositories.domain.model.RepositoryModel.ERROR_WHILE_READING_VALUE_FROM_URI_ERROR_MESSAGE;

@Service
public class RepositoryService {

    private Logger logger = LoggerFactory.getLogger(RepositoryService.class);
    private ObjectMapper objectMapper = new ObjectMapper();
    private RepositoryManager repositoryManager;

    @Autowired
    public RepositoryService(RepositoryManager repositoryManager) {
        this.repositoryManager = repositoryManager;
    }

    public Optional<RepositoryEntity> getLastUpdatedRepositoryOfCompany(String company) {
        try {
            return repositoryManager.findLastUpdatedRepository(getRepositoriesFromUrl(company));
        } catch (Exception e) {
            logger.error(ERROR_WHILE_GETTING_REPOSITORIES_FROM_URL_ERROR_MESSAGE, e);
            return Optional.empty();
        }
    }

    private List<RepositoryEntity> getRepositoriesFromUrl(String company) {
        try {
            registerJavaTimeModuleInObjectMapper();
            return objectMapper.readValue(createUri(company).build().toURL(), getValueTypeRef());
        } catch (IOException e) {
            logger.error(ERROR_WHILE_READING_VALUE_FROM_URI_ERROR_MESSAGE, e);
            return Collections.emptyList();
        } catch (Exception e) {
            logger.error(ERROR_WHILE_GETTING_LIST_OF_REPOSITORY_ENTITIES_ERROR_MESSAGE, e);
            return Collections.emptyList();
        }
    }

    private ObjectMapper registerJavaTimeModuleInObjectMapper() {
        return objectMapper.registerModule(new JavaTimeModule());
    }

    private TypeReference<List<RepositoryEntity>> getValueTypeRef() {
        return new TypeReference<List<RepositoryEntity>>() {};
    }

    private URIBuilder createUri(String company) {
        return new URIBuilder()
                .setScheme(HTTPS)
                .setHost(API_GITHUB_COM)
                .setPath(getPath(company))
                .addParameter(SORT, UPDATED)
                .addParameter(TYPE, PUBLIC);
    }

    private String getPath(String company) {
        return ORGS + SLASH + company + SLASH + REPOS;
    }
}