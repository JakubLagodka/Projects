package it.unipol.crm.sinistro.model.sinistro;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.math.BigInteger;
import java.time.LocalDateTime;

import static it.unipol.crm.sinistro.config.Constants.INPUT_DATE_TIME_FORMAT;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class SinistroRisp extends Sinistro {

    private BigInteger id;                              // [claimId] identificativo sinistro (example: 279841945880287600)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = INPUT_DATE_TIME_FORMAT)
    private LocalDateTime dataUltimoAggiornamento;      // [lastUpdateDt] data ultimo aggiornamento (example: 2023-01-01)
}
