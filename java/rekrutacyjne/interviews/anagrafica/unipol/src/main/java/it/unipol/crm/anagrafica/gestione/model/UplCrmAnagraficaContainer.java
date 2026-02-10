package it.unipol.crm.anagrafica.gestione.model;

import it.unipol.crm.anagrafica.gestione.entity.code.*;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.math.BigInteger;

@Data
@Component
public class UplCrmAnagraficaContainer {
    private BigInteger idSoggetto;
    private UplCrmAnagraficaAgenzia uplCrmAnagraficaAgenzia;
    private UplCrmAnagrafiche uplCrmAnagrafiche;
    private UplCrmAnagrafichePf uplCrmAnagrafichePf;
    private UplCrmAnagrafichePg uplCrmAnagrafichePg;
    private UplCrmAnomalieAnagrafiche uplCrmAnomaleAnagrafiche;
    private  UplCrmAnagRel uplCrmAnagRel;
    private  UplCrmDatiSocioeconomici uplCrmDatiSocioeconomici;
    private UplCrmDatiSocioeconomiciPf uplCrmDatiSocioeconomiciPf;
    private UplCrmDatiSocioeconomiciPfErrori uplCrmDatiSocioeconomiciPfErrori;
    private  UplCrmDocumenti uplCrmDocumenti;
    private  UplCrmIndirizzi uplCrmIndirizzi;
    private  UplCrmRecapiti uplCrmRecapiti;
    private UplCrmAnagraficaIdentita uplCrmAnagraficaIdentita;
}
