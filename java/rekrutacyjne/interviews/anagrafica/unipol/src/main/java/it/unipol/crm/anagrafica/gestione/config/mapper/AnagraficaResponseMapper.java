package it.unipol.crm.anagrafica.gestione.config.mapper;

import it.unipol.crm.anagrafica.gestione.model.AnagraficaResponse;
import it.unipol.crm.anagrafica.gestione.model.definitions.CreaAnagraficaRequest;
import it.unipol.crm.anagrafica.gestione.model.definitions.UpdateAnagraficaRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {DateMapper.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface AnagraficaResponseMapper {
    @Mapping(source = "idSoggetto", target = "idSoggetto")
    @Mapping(source = "datiAnagrafici", target = "datiAnagrafici")
    @Mapping(source = "personaFisica", target = "personaFisica")
    @Mapping(source = "personaGiuridica", target = "personaGiuridica")
    @Mapping(source = "identita", target = "identita")
    @Mapping(source = "agenzia", target = "agenzia")
    @Mapping(source = "recapiti", target = "recapiti")
    @Mapping(source = "documenti", target = "documenti")
    @Mapping(source = "anomalieAnagrafiche", target = "anomalieAnagrafiche")
    @Mapping(source = "datiSocioEconomici", target = "datiSocioEconomici")
    @Mapping(source = "datiSocioEconomiciPersoneFisiche", target = "datiSocioEconomiciPersoneFisiche")
    @Mapping(source = "datiSocioEconomiciPersoneFisicheErrori", target = "datiSocioEconomiciPersoneFisicheErrori")
    @Mapping(source = "anagRel", target = "anagRel")
    @Mapping(source = "privacyProspect", target = "privacyProspect")
    @Mapping(source = "indirizzi", target = "indirizzi")
    AnagraficaResponse convertUpdateAnagraficaRequestToAnagraficaResponse(UpdateAnagraficaRequest input);

    @Mapping(source = "datiAnagrafici.tipoNdg", target = "idSoggetto")
    @Mapping(source = "datiAnagrafici", target = "datiAnagrafici")
    @Mapping(source = "personaFisica", target = "personaFisica")
    @Mapping(source = "personaGiuridica", target = "personaGiuridica")
    @Mapping(source = "identita", target = "identita")
    @Mapping(source = "agenzia", target = "agenzia")
    @Mapping(source = "recapiti", target = "recapiti")
    @Mapping(source = "documenti", target = "documenti")
    @Mapping(source = "anomalieAnagrafiche", target = "anomalieAnagrafiche")
    @Mapping(source = "datiSocioEconomici", target = "datiSocioEconomici")
    @Mapping(source = "datiSocioEconomiciPersoneFisiche", target = "datiSocioEconomiciPersoneFisiche")
    @Mapping(source = "datiSocioEconomiciPersoneFisicheErrori", target = "datiSocioEconomiciPersoneFisicheErrori")
    @Mapping(source = "anagRel", target = "anagRel")
    @Mapping(source = "privacyProspect", target = "privacyProspect")
    @Mapping(source = "indirizzi", target = "indirizzi")
    AnagraficaResponse convertCreaAnagraficaRequestToAnagraficaResponse(CreaAnagraficaRequest input);
}
