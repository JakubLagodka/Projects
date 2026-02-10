package it.unipol.crm.anagrafica.gestione.model.definitions;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigInteger;
import java.time.LocalDateTime;

import static it.unipol.crm.anagrafica.gestione.config.Constants.DATE_TIME_FORMAT;

@Data
public class DatiSocioEconomiciPersoneFisicheErrori {
    private BigInteger idDatiSocioEconomiciPersoneFisicheErrori	;
    private String compagnia	;
    private String statoCivileF	;
    private String flagFigliF	;
    private String annoFiglio1F	;
    private String annoFiglio2F	;
    private String annoFiglio3F	;
    private String annoFiglio4F	;
    private String titoloStudioF	;
    private String interesseFaiDaTeF	;
    private String interesseMusicaF	;
    private String interesseSalute	;
    private String interesseLetturaF	;
    private String interesseNatura	;
    private String interesseVolontariatoF	;
    private String interesseFotoF	;
    private String interesseTecnologia	;
    private String interesseSportF	;
    private String interesseViaggiF	;
    private String interesseMotoriF	;
    private String interesseEnogastronomiaF	;
    private String inetLavoroF	;
    private String inetSocialF	;
    private String inetAcquistiF	;
    private String inetAppF	;
    private String casaProprF	;
    private String casaAffittoF	;
    private String casaSecondaF	;
    private String casaMutuoF	;
    private String tipoRisparmiatoreF	;
    private String infoRispAutoF	;
    private String infoIntPensF	;
    private String infoRispNoRischiF	;
    private String infoStudioFigliF	;
    private String infoRendCapF	;
    private String infoEreditaF	;
    private String infoAssistenzaF	;
    private String infoTerremotoF	;
    private String infoDanniF	;
    private String infoIndennizzoF	;
    private String infoPerditaImpiegoF	;
    private String prevCambioAuto	;
    private String prevPensioneF	;
    private String prevMutuoF	;
    private String prevNuovaAttF	;
    private String prevPromozionFe	;
    private String prevVacanzaF	;
    private String prevFineStudioFigliF	;
    private String prevCambioCasaF	;
    private String recCellulareF	;
    private String recTelefonoF	;
    private String recFaxF	;
    private String recMailF	;
    private String professioneF	;
    private String firma1F	;
    private String firma2F	;
    private String logErrori	;
    private String utenteAggiornamento	;
    @JsonFormat(pattern = DATE_TIME_FORMAT)
    private LocalDateTime dataInserimento;
    @JsonFormat(pattern = DATE_TIME_FORMAT)
    private LocalDateTime dataAggiornamento;
    private String utenteInserimento;
}
