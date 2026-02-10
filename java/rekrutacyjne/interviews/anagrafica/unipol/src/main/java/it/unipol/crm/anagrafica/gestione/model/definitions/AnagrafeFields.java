package it.unipol.crm.anagrafica.gestione.model.definitions;

import lombok.Data;

@Data
public class AnagrafeFields {
    private DatiAnagrafici datiAnagrafici;
    private PersonaFisica personaFisica;
    private PersonaGiuridica personaGiuridica;
    private Identita identita;
    private Agenzia agenzia;
    private Indirizzi indirizzi;
    private Recapiti recapiti;
    private Documenti documenti;
    private AnomalieAnagrafiche anomalieAnagrafiche;
    private DatiSocioEconomici datiSocioEconomici;
    private DatiSocioEconomiciPersoneFisiche datiSocioEconomiciPersoneFisiche;
    private DatiSocioEconomiciPersoneFisicheErrori datiSocioEconomiciPersoneFisicheErrori;
    private AnagRel anagRel;
    private PrivacyProspect privacyProspect;
}
