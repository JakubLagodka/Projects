package it.unipolsai.crmo.incassi.persistence.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.SQLException;

import static it.unipolsai.crmo.incassi.persistence.config.DatabaseConfiguration.PERSISTENCE_DATA_SOURCE_BEAN_NAME;

@Component
public class DatabasePopulator {

    @Autowired
    @Qualifier(PERSISTENCE_DATA_SOURCE_BEAN_NAME)
    private DataSource testH2DataSource;

    public void populateDatabaseBeforeTestsInClass() {
        ResourceDatabasePopulator populator = new ResourceDatabasePopulator();

        populator.addScript(new ClassPathResource("db_scripts/dropAndCreate-UPL_CRM_INCASSI_ONLINE.sql"));
        populator.addScript(new ClassPathResource("db_scripts/dropAndCreate-UPL_CRM_ARRETRATI.sql"));
        populator.addScript(new ClassPathResource("db_scripts/dropAndCreate-UPL_CRM_ARRETRATI_RETT.sql"));

        // populate
        populator.addScript(new ClassPathResource("db_scripts/insert-UPL_CRM_INCASSI_ONLINE.sql"));
        populator.addScript(new ClassPathResource("db_scripts/insert-UPL_CRM_ARRETRATI.sql"));
        populator.addScript(new ClassPathResource("db_scripts/insert-UPL_CRM_ARRETRATI_RETT.sql"));

        try {
            populator.populate(testH2DataSource.getConnection());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}