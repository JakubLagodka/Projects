package it.unipol.crm.anagrafica.gestione.config.mapper;

import it.unipol.crm.anagrafica.gestione.entity.code.*;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {DateMapper.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface AnagraficaEntitiesUpdateMapper {
    void uplCrmAnagraficaAgenziaUpdate(@MappingTarget UplCrmAnagraficaAgenzia target, UplCrmAnagraficaAgenzia source);
    void uplCrmAnagraficheUpdate(@MappingTarget UplCrmAnagrafiche target, UplCrmAnagrafiche source);
    void uplCrmAnagraficaIdentitaUpdate(@MappingTarget UplCrmAnagraficaIdentita target, UplCrmAnagraficaIdentita source);
    void uplCrmAnagrafichePfUpdate(@MappingTarget UplCrmAnagrafichePf target, UplCrmAnagrafichePf source);
    void uplCrmAnagrafichePgUpdate(@MappingTarget UplCrmAnagrafichePg target, UplCrmAnagrafichePg source);
    void uplCrmAnagRelUpdate(@MappingTarget UplCrmAnagRel target, UplCrmAnagRel source);
    void uplCrmIndirizziUpdate(@MappingTarget UplCrmIndirizzi target, UplCrmIndirizzi source);
    void uplCrmDocumentiUpdate(@MappingTarget UplCrmDocumenti target, UplCrmDocumenti source);
    void uplCrmRecapitiUpdate(@MappingTarget UplCrmRecapiti target, UplCrmRecapiti source);
    void uplCrmDatiSocioeconomiciUpdate(@MappingTarget UplCrmDatiSocioeconomici target, UplCrmDatiSocioeconomici source);
    void uplCrmDatiSocioeconomiciPfUpdate(@MappingTarget UplCrmDatiSocioeconomiciPf target, UplCrmDatiSocioeconomiciPf source);
    void uplCrmDatiSocioeconomiciPfErroriUpdate(@MappingTarget UplCrmDatiSocioeconomiciPfErrori target, UplCrmDatiSocioeconomiciPfErrori source);
    void uplCrmAnomalieAnagraficheUpdate(@MappingTarget UplCrmAnomalieAnagrafiche target, UplCrmAnomalieAnagrafiche source);
}
