package com.allegro.repositories.domain.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import static com.allegro.repositories.domain.model.RepositoryModel.NAME;
import static com.allegro.repositories.domain.model.RepositoryModel.UPDATED_AT;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RepositoryEntity {

    @JsonProperty(NAME)
    private String name;

    @JsonProperty(UPDATED_AT)
    private LocalDate latestUpdate;

    public RepositoryEntity() {

    }

    public RepositoryEntity(String name, LocalDate latestUpdate) {
        this.name = name;
        this.latestUpdate = latestUpdate;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getLatestUpdate() {
        return latestUpdate;
    }

    public void setLatestUpdate(LocalDate latestUpdate) {
        this.latestUpdate = latestUpdate;
    }
}