package it.unipol.crm.attivita.batch.stsclient.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class StsResponse {

    private String token;

    @JsonProperty("expires_in")
    private Integer expiresIn;

    private String identity;
}
