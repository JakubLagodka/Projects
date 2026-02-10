package it.unipol.crm.sinistro.model.ruolo;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;

import java.math.BigInteger;
import java.util.Arrays;

@Getter
public enum CodRuolo {

    CONTRAENTE(BigInteger.valueOf(1001)),
    PROPRIETARIO_AUTO_SINISTRATA(BigInteger.valueOf(1002));

    public final BigInteger value;

    CodRuolo(BigInteger value) {
        this.value = value;
    }

    @JsonCreator
    public static CodRuolo fromBigInteger(BigInteger givenValue) {

        return Arrays.stream(CodRuolo.values())
                .filter(value -> value.getValue().equals(givenValue))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Wrong given type of codRuolo: " + givenValue));
    }

    @JsonCreator
    public static CodRuolo fromString(String givenValue) {

        return Arrays.stream(CodRuolo.values())
                .filter(value -> value.name().equalsIgnoreCase(givenValue))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Wrong given type of codRuolo: " + givenValue));
    }
}