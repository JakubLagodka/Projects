package it.unipol.crm.attivita.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;

import java.util.Arrays;

@Getter
public enum OperationType {

    INSERT("I"),
    UPDATE("U"),
    DELETE("D");

    public final String value;

    private OperationType(String value) {
        this.value = value;
    }

    @JsonCreator
    public static OperationType fromString(String givenValue) {

        return Arrays.stream(OperationType.values())
                .filter(value -> value.getValue().equalsIgnoreCase(givenValue))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Wrong given type of operationType: " + givenValue));
    }
}
