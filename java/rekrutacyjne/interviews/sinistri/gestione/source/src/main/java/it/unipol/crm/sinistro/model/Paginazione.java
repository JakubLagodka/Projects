package it.unipol.crm.sinistro.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigInteger;

@Data
@AllArgsConstructor
public class Paginazione {

    private BigInteger totale;                  // numero totale di risultati (example: 99)
    private Integer risultatiPerPagina;         // numero di risultati per pagina (example: 20)
    private Integer pagina;                     // numero pagina (example: 2)
}