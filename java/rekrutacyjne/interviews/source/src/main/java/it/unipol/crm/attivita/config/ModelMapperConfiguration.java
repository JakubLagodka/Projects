package it.unipol.crm.attivita.config;

import it.unipol.crm.attivita.persistence.model.Attivita;
import it.unipol.crm.attivita.model.McEventi;
import it.unipol.crm.attivita.persistence.entity.attivita.UplCrmAttivita;
import it.unipol.crm.attivita.persistence.entity.mceventi.UplCrmMcEventi;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Optional;

@Configuration
public class ModelMapperConfiguration {

    @Bean
    public ModelMapper getModelMapper() {
        ModelMapper mapper = new ModelMapper();
        configureMappings(mapper);
        return mapper;
    }

    public static void configureMappings(ModelMapper mapper) {
        mapper.getConfiguration()
                .setSkipNullEnabled(true)
                .setMatchingStrategy(MatchingStrategies.STRICT);

        mapper.typeMap(Attivita.class, UplCrmAttivita.class).addMappings(m -> {
            m.map(Attivita::getId, UplCrmAttivita::setAttivitaId);
            m.map(Attivita::getDataCreazione, UplCrmAttivita::setCreazioneDt);
            m.map(Attivita::getCodiceFiscaleCliente, UplCrmAttivita::setCfpivaCliente);
            m.map(Attivita::getContestoIdentificativo, UplCrmAttivita::setContextId);
            m.map(Attivita::getContestoEntita, UplCrmAttivita::setContextEntity);
            m.map(Attivita::getContestoChiavePrimaria, UplCrmAttivita::setContextInstancePk);
            m.map(Attivita::getCodiceStatoAttivita, UplCrmAttivita::setAttivitaStTpCd);
            m.map(Attivita::getDataAvvio, UplCrmAttivita::setAvvioDt);
            m.map(Attivita::getDataScadenza, UplCrmAttivita::setScadenzaDt);
            m.map(Attivita::getDataCompletamento, UplCrmAttivita::setCompletataDt);
            m.map(Attivita::getDataFine, UplCrmAttivita::setFineDt);
            m.map(Attivita::getDataRiapertura, UplCrmAttivita::setRiaperturaDt);
            m.map(Attivita::getDataEscalation, UplCrmAttivita::setEscalationDt);
            m.map(Attivita::getAssegnatoreDescrizione, UplCrmAttivita::setAssegnatoreDesc);
            m.map(Attivita::getAssegnatarioDescrizione, UplCrmAttivita::setAssegnatarioDesc);
            m.map(Attivita::getInLavorazioneDaData, UplCrmAttivita::setInLavorazioneDaDt);
            m.map(Attivita::getCipSubagente, UplCrmAttivita::setCipSub);
            m.map(Attivita::getCipProduttore, UplCrmAttivita::setCipProd);
            m.map(Attivita::getDelegaContactCentre, UplCrmAttivita::setDelegaCc);
            m.map(Attivita::getDelegaContactCentreAbilitata, UplCrmAttivita::setDelegaCcAbilitata);
            m.map(Attivita::getDelegaContactCentreIniziale, UplCrmAttivita::setDelegaCcIniziale);
            m.map(Attivita::getGestioneMulticanale, UplCrmAttivita::setGestioneMc);
            m.map(Attivita::getRicontattoNumero, UplCrmAttivita::setNumRicontatto);
            m.map(Attivita::getMotivoRichiestaRiscatto, UplCrmAttivita::setMotivRichiestaRiscatto);
            m.map(Attivita::getDataSospensioneRiattivazionePolizza, UplCrmAttivita::setDataSospRiattPolizza);
            m.map(Attivita::getUtenteUltimoAggiornamento, UplCrmAttivita::setLastUpdateUser);
            m.map(Attivita::getDataUltimoAggiornamento, UplCrmAttivita::setLastUpdateDt);
            m.map(Attivita::getRicontattoFasciaOraria, UplCrmAttivita::setFasciaOrariaRicontatto);
            m.map(Attivita::getRcDate, UplCrmAttivita::setRcDt);
        });

        mapper.typeMap(UplCrmAttivita.class, Attivita.class).addMappings(m -> {
            m.map(UplCrmAttivita::getAttivitaId, Attivita::setId);
            m.map(UplCrmAttivita::getCreazioneDt, Attivita::setDataCreazione);
            m.map(UplCrmAttivita::getCfpivaCliente, Attivita::setCodiceFiscaleCliente);
            m.map(UplCrmAttivita::getContextId, Attivita::setContestoIdentificativo);
            m.map(UplCrmAttivita::getContextEntity, Attivita::setContestoEntita);
            m.map(UplCrmAttivita::getContextInstancePk, Attivita::setContestoChiavePrimaria);
            m.map(UplCrmAttivita::getAttivitaStTpCd, Attivita::setCodiceStatoAttivita);
            m.map(UplCrmAttivita::getAvvioDt, Attivita::setDataAvvio);
            m.map(UplCrmAttivita::getScadenzaDt, Attivita::setDataScadenza);
            m.map(UplCrmAttivita::getCompletataDt, Attivita::setDataCompletamento);
            m.map(UplCrmAttivita::getFineDt, Attivita::setDataFine);
            m.map(UplCrmAttivita::getRiaperturaDt, Attivita::setDataRiapertura);
            m.map(UplCrmAttivita::getEscalationDt, Attivita::setDataEscalation);
            m.map(UplCrmAttivita::getAssegnatoreDesc, Attivita::setAssegnatoreDescrizione);
            m.map(UplCrmAttivita::getAssegnatarioDesc, Attivita::setAssegnatarioDescrizione);
            m.map(UplCrmAttivita::getInLavorazioneDaDt, Attivita::setInLavorazioneDaData);
            m.map(UplCrmAttivita::getCipSub, Attivita::setCipSubagente);
            m.map(UplCrmAttivita::getCipProd, Attivita::setCipProduttore);
            m.map(UplCrmAttivita::getDelegaCc, Attivita::setDelegaContactCentre);
            m.map(UplCrmAttivita::getDelegaCcAbilitata, Attivita::setDelegaContactCentreAbilitata);
            m.map(UplCrmAttivita::getDelegaCcIniziale, Attivita::setDelegaContactCentreIniziale);
            m.map(UplCrmAttivita::getGestioneMc, Attivita::setGestioneMulticanale);
            m.map(UplCrmAttivita::getNumRicontatto, Attivita::setRicontattoNumero);
            m.map(UplCrmAttivita::getMotivRichiestaRiscatto, Attivita::setMotivoRichiestaRiscatto);
            m.map(UplCrmAttivita::getDataSospRiattPolizza, Attivita::setDataSospensioneRiattivazionePolizza);
            m.map(UplCrmAttivita::getLastUpdateUser, Attivita::setUtenteUltimoAggiornamento);
            m.map(UplCrmAttivita::getLastUpdateDt, Attivita::setDataUltimoAggiornamento);
            m.map(UplCrmAttivita::getFasciaOrariaRicontatto, Attivita::setRicontattoFasciaOraria);
            m.map(UplCrmAttivita::getRcDt, Attivita::setRcDate);
        });

        mapper.typeMap(McEventi.class, UplCrmMcEventi.class).addMappings(m -> {
            m.map(McEventi::getMcEventiId, UplCrmMcEventi::setMcEventiId);
            m.map(McEventi::getEntityName, UplCrmMcEventi::setEntityName);
            m.map(McEventi::getIdProcesso, UplCrmMcEventi::setIdProcesso);
            m.map(McEventi::getIdAttivita, UplCrmMcEventi::setIdAttivita);
            m.map(McEventi::getDataOperazione, UplCrmMcEventi::setDataOperazione);
            m.map(McEventi::getEsitoContattoTpCd, UplCrmMcEventi::setEsitoContattoTpCd);
            m.map(McEventi::getNota, UplCrmMcEventi::setNota);
            m.map(McEventi::getSottoEsitoContattoTpCd, UplCrmMcEventi::setSottoEsitoContattoTpCd);
            m.map(McEventi::getCreatoDaUtente, UplCrmMcEventi::setCreatoDaUtente);
            m.map(McEventi::getCreatoDaNominativo, UplCrmMcEventi::setCreatoDaNominativo);
            m.map(McEventi::getCanaleTpCd, UplCrmMcEventi::setCanaleTpCd);
            m.map(McEventi::getDataRecall, UplCrmMcEventi::setDataRecall);
            m.map(McEventi::getEntityId, UplCrmMcEventi::setEntityId);
            m.map(McEventi::getAgeEvento, UplCrmMcEventi::setAgeEvento);
            m.map(McEventi::getLastUpdateUser, UplCrmMcEventi::setLastUpdateUser);
        });

        mapper.typeMap(UplCrmMcEventi.class, McEventi.class).addMappings(m -> {
            m.map(UplCrmMcEventi::getMcEventiId, McEventi::setMcEventiId);
            m.map(UplCrmMcEventi::getEntityName, McEventi::setEntityName);
            m.map(UplCrmMcEventi::getIdProcesso, McEventi::setIdProcesso);
            m.map(UplCrmMcEventi::getIdAttivita, McEventi::setIdAttivita);
            m.map(UplCrmMcEventi::getDataOperazione, McEventi::setDataOperazione);
            m.map(UplCrmMcEventi::getEsitoContattoTpCd, McEventi::setEsitoContattoTpCd);
            m.map(UplCrmMcEventi::getNota, McEventi::setNota);
            m.map(UplCrmMcEventi::getSottoEsitoContattoTpCd, McEventi::setSottoEsitoContattoTpCd);
            m.map(UplCrmMcEventi::getCreatoDaUtente, McEventi::setCreatoDaUtente);
            m.map(UplCrmMcEventi::getCreatoDaNominativo, McEventi::setCreatoDaNominativo);
            m.map(UplCrmMcEventi::getCanaleTpCd, McEventi::setCanaleTpCd);
            m.map(UplCrmMcEventi::getDataRecall, McEventi::setDataRecall);
            m.map(UplCrmMcEventi::getEntityId, McEventi::setEntityId);
            m.map(UplCrmMcEventi::getAgeEvento, McEventi::setAgeEvento);
            m.map(UplCrmMcEventi::getLastUpdateUser, McEventi::setLastUpdateUser);
        });

        mapper.addConverter(src -> Optional.ofNullable(src.getSource())
                        .map(java.sql.Date::valueOf)
                        .orElse(null)
                , LocalDate.class, Date.class);

        mapper.addConverter(ModelMapperConfiguration::toLocalDate
                , Date.class, LocalDate.class);

        mapper.addConverter(src -> Optional.ofNullable(src.getSource())
                        .map(Timestamp::valueOf)
                        .orElse(null)
                , LocalDateTime.class, Timestamp.class);

        mapper.addConverter(src -> Optional.ofNullable(src.getSource())
                        .map(Timestamp::toLocalDateTime)
                        .orElse(null)
                , Timestamp.class, LocalDateTime.class);
    }


    private static LocalDate toLocalDate(org.modelmapper.spi.MappingContext<Date, LocalDate> src) {
        Date date = src.getSource();
        if (date instanceof java.sql.Date) {
            return Optional.of((java.sql.Date) date)
                    .map(java.sql.Date::toLocalDate)
                    .orElse(null);
        } else {
            return Optional.ofNullable(date)
                    .map(Date::toInstant)
                    .map(i -> i.atZone(ZoneId.systemDefault()))
                    .map(ZonedDateTime::toLocalDate)
                    .orElse(null);
        }

    }
}