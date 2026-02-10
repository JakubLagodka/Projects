package it.unipol.crm.anagrafica.gestione.model.definitions;

import lombok.Data;

import java.math.BigInteger;

@Data
public class UpdateAnagraficaRequest extends CreaAnagraficaRequest {
    private BigInteger idSoggetto;
}
