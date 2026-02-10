package it.unipol.crm.attivita.batch.config;

import it.unipol.crm.attivita.batch.model.WccAttivita;
import it.unipol.crm.attivita.persistence.entity.attivita.UplCrmAttivita;
import it.unipol.crm.attivita.persistence.model.Attivita;
import it.unipol.crm.attivita.persistence.model.NuovaAttivita;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Optional;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper getModelMapper() {
        ModelMapper mapper = new ModelMapper();
        configureMapper(mapper);
        return mapper;
    }

    public static ModelMapper configureMapper(ModelMapper mapper) {
        mapper.getConfiguration()
                .setSkipNullEnabled(true);
        mapper.typeMap(WccAttivita.class, NuovaAttivita.class).addMappings(m -> {
            m.map(WccAttivita::getCfpivaCliente, NuovaAttivita::setCodiceFiscaleCliente);
            m.map(WccAttivita::getContextId, NuovaAttivita::setContestoIdentificativo);
            m.map(WccAttivita::getAvvioDt, NuovaAttivita::setDataAvvio);
            m.map(WccAttivita::getScadenzaDt, NuovaAttivita::setDataScadenza);
            m.map(WccAttivita::getAssegnatarioDesc, NuovaAttivita::setAssegnatarioDescrizione);
            m.map(WccAttivita::getDelegaCc, NuovaAttivita::setDelegaContactCentre);
            m.map(WccAttivita::getDelegaCcAbilitata, NuovaAttivita::setDelegaContactCentreAbilitata);
            m.map(WccAttivita::getDelegaCcIniziale, NuovaAttivita::setDelegaContactCentreIniziale);
            m.map(WccAttivita::getGestioneMc, NuovaAttivita::setGestioneMulticanale);
        });

        mapper.addConverter(src -> Optional.ofNullable(src.getSource())
                        .map(java.sql.Date::valueOf)
                        .orElse(null)
                , LocalDate.class, Date.class);

        mapper.addConverter(ModelMapperConfig::toLocalDate
                , Date.class, LocalDate.class);

        mapper.addConverter(src -> Optional.ofNullable(src.getSource())
                        .map(Timestamp::valueOf)
                        .orElse(null)
                , LocalDateTime.class, Timestamp.class);

        mapper.addConverter(src -> Optional.ofNullable(src.getSource())
                        .map(Timestamp::toLocalDateTime)
                        .orElse(null)
                , Timestamp.class, LocalDateTime.class);

        return mapper;
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
