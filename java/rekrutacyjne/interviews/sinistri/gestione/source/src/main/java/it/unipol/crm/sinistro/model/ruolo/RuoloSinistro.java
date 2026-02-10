package it.unipol.crm.sinistro.model.ruolo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.time.LocalDate;

import static it.unipol.crm.sinistro.config.Constants.INPUT_DATE_FORMAT;

@Data
@NoArgsConstructor
public class RuoloSinistro {

    private CodRuolo codRuolo;          // [claimRoleTpCd] Contraente (1001), Proprietario Auto Sinistrata (1002) (example: CONTRAENTE)
    private BigInteger contattoId;      // [contId] identificativo contatto (example: 279841945880287600)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = INPUT_DATE_FORMAT)
    private LocalDate dataFine;         // [endDt] data fine validità (example: 2023-01-01)
}