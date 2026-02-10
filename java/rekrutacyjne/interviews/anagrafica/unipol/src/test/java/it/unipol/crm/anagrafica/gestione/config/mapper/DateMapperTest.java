package it.unipol.crm.anagrafica.gestione.config.mapper;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DateMapperTest {

    @Autowired
    DateMapper dateMapper;

    @Test
    void shouldConvertDates() {

        // given
        LocalDate localDate = LocalDate.of(2020, 12, 12);
        LocalDateTime localDateTime = LocalDateTime.of(2020, 12, 12, 12, 12, 12);
        Timestamp timestampStart = Timestamp.valueOf("2020-12-12 0:00:00.000");
        Timestamp timestamp = Timestamp.valueOf("2020-12-12 12:12:12.000");

        // then
        assertEquals(timestampStart, dateMapper.localDateToTimestamp(localDate));
        assertEquals(timestamp, dateMapper.localDateTimeToTimestamp(localDateTime));
        assertEquals(localDate, dateMapper.timestampToLocalDate(timestamp));
        assertEquals(localDateTime, dateMapper.timestampToLocalDateTime(timestamp));

        assertNull(dateMapper.localDateToTimestamp(null));
        assertNull(dateMapper.localDateTimeToTimestamp(null));
        assertNull(dateMapper.timestampToLocalDate(null));
        assertNull(dateMapper.timestampToLocalDateTime(null));
    }

    @Test
    void shouldReturnNullWhenStringToLocalDateTimeIsNull(){

        LocalDateTime actual = dateMapper.stringToLocalDateTime(null);

        assertNull(actual);
    }

    @Test
    void shouldReturnDateWhenStringToLocalDateTimeIsCorrect(){

        LocalDateTime expected = LocalDateTime.of(2007, 12, 3, 10, 15, 30);

        LocalDateTime actual = dateMapper.stringToLocalDateTime("2007-12-03T10:15:30");

        assertNotNull(actual);
        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnDateWhenStringToLocalDateTimeIsCorrectWithoutHours(){

        LocalDateTime expected = LocalDateTime.of(2007, 12, 3, 0, 0, 0);

        LocalDateTime actual = dateMapper.stringToLocalDateTime("2007-12-03");

        assertNotNull(actual);
        assertEquals(expected, actual);
    }

    @Test
    void shouldConvertSqlDate(){
        LocalDate expected = LocalDate.of(2023, 4, 5);


        LocalDate actual = dateMapper.dateToLocalDate(convertStringToDate("2023-04-05"));

        assertNotNull(actual);
        assertEquals(expected, actual);

    }

    @Test
    void shouldConvertUtilDate(){
        LocalDate expected = LocalDate.of(1995, 8, 12);


        LocalDate actual = dateMapper.dateToLocalDate(new java.util.Date(java.util.Date.parse("Sat, 12 Aug 1995 13:30:00 GMT")));

        assertNotNull(actual);
        assertEquals(expected, actual);
    }

    public static Date convertStringToDate(String input) {
        if (StringUtils.isEmpty(input)) {
            return null;
        }

        var dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {
            return new Date(dateFormat.parse(input).getTime());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
