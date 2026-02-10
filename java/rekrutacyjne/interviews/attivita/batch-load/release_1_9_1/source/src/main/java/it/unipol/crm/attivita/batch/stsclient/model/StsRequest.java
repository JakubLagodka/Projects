package it.unipol.crm.attivita.batch.stsclient.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class StsRequest {

    private String provideType;
    private String provideDomain;
    private String requireType;
    private String requireDomain;
    private String scope;
    private String token;

    public StsRequest(@Value("${STS_PROVIDE_TYPE}") String provideType,
                      @Value("${STS_PROVIDE_DOMAIN}") String provideDomain,
                      @Value("${STS_REQUIRE_TYPE}") String requireType,
                      @Value("${STS_REQUIRE_DOMAIN}") String requireDomain,
                      @Value("${STS_SCOPE}") String scope) {

        this.provideType = provideType;
        this.provideDomain = provideDomain;
        this.requireType = requireType;
        this.requireDomain = requireDomain;
        this.scope = scope;
    }
}
