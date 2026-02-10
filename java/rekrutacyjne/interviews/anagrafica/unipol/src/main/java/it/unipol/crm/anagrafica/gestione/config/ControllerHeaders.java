package it.unipol.crm.anagrafica.gestione.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class ControllerHeaders {

    public static final String X_UNIPOL_REQUESTID     = "X-UNIPOL-REQUESTID";
    public static final String X_UNIPOL_APPLICATION = "X-UNIPOL-APPLICATION";
    public static final String X_UNIPOL_APPLICATIONID_VALUE = "anagrafica-gestione";
}
