package it.unipol.crm.anagrafica.gestione.model;

import lombok.Data;

@Data
public class RisorsaErrore {
    private Integer codiceErrore;
    private String messaggioErrore;
    private String informazioniAggiuntive;
}
