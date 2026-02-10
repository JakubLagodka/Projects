package it.unipol.crm.sinistro.model.sinistro;

import com.fasterxml.jackson.annotation.JsonFormat;
import it.unipol.crm.sinistro.model.contratto.ContrattoAssociato;
import it.unipol.crm.sinistro.model.ruolo.RuoloSinistro;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;

import static it.unipol.crm.sinistro.config.Constants.INPUT_DATE_FORMAT;

@Data
@NoArgsConstructor
@EqualsAndHashCode
public class Sinistro {

    private String chiaveSinistro;                  // [adminRefNum] chaive logica del sinistro (example: 120160890000247340)
    private String numero;                          // [claimNumber] numero del sinistro (example: 10129001290080)
    private BigDecimal importo;                     // [claimDetailAmt] importo che si prevede di pagare (example: 123,45)
    private BigDecimal importoLiquidato;            // [claimPaidAmt] importo liquidato (example: 123,45)
    private BigInteger numeroPolizza;               // [outstandingAmt] numero polizza associata (example: 123456789)
    private BigInteger agenzia;                     // [benefitClaimAmt] agenzia del sinistro (example: 1234)
    private BigInteger ramo;                        // [claimTpCd] ramo polizza associata (example: 24)
    private BigInteger codStato;                    // [claimStatusTpCd] codice stato del sinistro (example: 1)
    private String codFiscControparte;              // [claimCode] codice fiscale controparte (example: AAABBB11A22C345F)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = INPUT_DATE_FORMAT)
    private LocalDate dataUltimaLiquidazione;        // [statusDt] data ultima liquidazione (example: 2023-01-01)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = INPUT_DATE_FORMAT)
    private LocalDate dataAvvenimento;              // [claimIncurredDt] data sinistro (example: 2023-01-01)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = INPUT_DATE_FORMAT)
    private LocalDate dataDenuncia;                 // [reportedDt] data denuncia (example: 2023-01-01)
    private String ragioneSocialeControparte;       // [description] ragione sociale controparte (example: Condominio ABC)
    private List<RuoloSinistro> ruoli;
    private ContrattoAssociato contrattoAssociato;
}