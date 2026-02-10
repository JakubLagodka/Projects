package it.unipol.crm.anagrafica.gestione.config.mapper;

import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.*;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.Optional;


@Component
public class DateMapper {
    public Timestamp localDateToTimestamp(LocalDate input) {
        return input == null ? null : Timestamp.valueOf(input.atStartOfDay());
    }

    public LocalDate timestampToLocalDate(Timestamp input) {
        return input == null ? null : input.toLocalDateTime().toLocalDate();
    }

    public Timestamp localDateTimeToTimestamp(LocalDateTime input) {
        return input == null ? null : Timestamp.valueOf(input);
    }

    public LocalDateTime timestampToLocalDateTime(Timestamp input) {
        return input == null ? null : input.toLocalDateTime();
    }

    public LocalDate dateToLocalDate(Date date) {
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
    public LocalDateTime stringToLocalDateTime(String input) {
        if (input == null)
            return null;

        LocalDateTime out;
        try {
            out = LocalDateTime.parse(input);
        }
        catch (DateTimeParseException e) {
            out = LocalDate.parse(input).atStartOfDay();
        }

        return out;
    }
}
