package it.unipol.crm.anagrafica.gestione.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class HeaderParameters {
    private String requestId;
    private String applicationId;
    public boolean checkIfHeaderParametersAreProper(String xUnipolRequestId, String xUnipolApplication){
        requestId = xUnipolRequestId;
        applicationId = xUnipolApplication;
        return requestId != null && !requestId.isBlank() &&
                applicationId != null && !applicationId.isBlank();
    }
}
