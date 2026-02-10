package it.unipol.crm.sinistro.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ErroreRisp {
    private String messaggioErrore;     // messaggio di errore (example: Descrizione dell'errore riscontrato)
}
