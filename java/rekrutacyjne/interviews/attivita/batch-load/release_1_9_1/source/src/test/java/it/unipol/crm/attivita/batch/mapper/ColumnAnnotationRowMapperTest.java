package it.unipol.crm.attivita.batch.mapper;

import it.unipol.crm.attivita.batch.config.DbConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.ConfigDataApplicationContextInitializer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.ZoneId;

import static org.junit.Assert.*;

@ContextConfiguration(classes = {DbConfiguration.class, ColumnAnnotationRowMapperTestConfig.class},
        initializers = ConfigDataApplicationContextInitializer.class)
@RunWith(SpringRunner.class)
public class ColumnAnnotationRowMapperTest {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Autowired
    private ItemReader<AllTypesModel> allTypesModelItemReader;

    @Autowired
    @Qualifier("inputDataSource")
    private DataSource inputDataSource;

    @Autowired
    private ColumnAnnotationRowMapper<AllTypesModel> fixture;

    @Test
    public void shouldMapSuccessfully() throws Exception {
        //given
        ResourceDatabasePopulator inputPopulator = new ResourceDatabasePopulator();
        inputPopulator.addScript(new ClassPathResource("/db/createAllTypesModelTable.sql"));
        inputPopulator.addScript(new ClassPathResource("/db/insertIntoAllTypesModel.sql"));
        DatabasePopulatorUtils.execute(inputPopulator, inputDataSource);

        //when
        AllTypesModel actual = allTypesModelItemReader.read();

        //then
        assertNotNull(actual);
        assertEquals(BigInteger.ONE, actual.getBigInteger());
        assertEquals(new BigDecimal("2.20"), actual.getBigDecimal());
        assertEquals(Long.valueOf(3), actual.getALong());
        assertEquals(Integer.valueOf(4), actual.getInteger());
        assertEquals("string value", actual.getString());
        assertEquals(true, actual.getABoolean());
        assertEquals(new Timestamp(sdf.parse("2011-01-01 01:00:00").getTime()), actual.getTimestamp());
        assertEquals(sdf.parse("2022-02-02 00:00:00"), actual.getDate());
        assertEquals(sdf.parse("2033-03-03 03:00:00").toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime(), actual.getLocalDateTime());
        assertNull("BigInt should be null", actual.getEmptyBigInteger());
        assertNull("Long should be null", actual.getEmptyLong());
    }
}