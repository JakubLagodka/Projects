package com.allegro.repositories.domain.model;

public enum ErrorMessages {

    ERROR_WHILE_GETTING_LIST_OF_REPOSITORY_ENTITIES("ErrorMessages while getting list of repository entities"),
    ERROR_WHILE_READING_VALUE_FROM_URI("Error while reading value from Uri"),
    ERROR_WHILE_GETTING_REPOSITORIES_FROM_URL("Error while getting repositories from url");

    private String errorMessage;

    ErrorMessages(String errorMsg) {
        this.errorMessage = errorMsg;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}