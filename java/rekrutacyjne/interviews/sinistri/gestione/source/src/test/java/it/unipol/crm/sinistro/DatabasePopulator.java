package it.unipol.crm.sinistro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.SQLException;

@Component
public class DatabasePopulator {
    @Autowired
    @Qualifier("sinistroPersistenceDataSource")
    private DataSource testH2DataSource;

    public void populateSinistroDatabaseBeforeTestsInClass() {
        ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
        populator.addScript(new ClassPathResource("./dropAndCreate-UPL_CRM_CLAIM.sql"));
        populator.addScript(new ClassPathResource("./dropAndCreate-UPL_CRM_CLAIMCONTRACT.sql"));
        populator.addScript(new ClassPathResource("./dropAndCreate-UPL_CRM_CLAIMROLE.sql"));
        populator.addScript(new ClassPathResource("./dropAndCreate-CONTACT.sql"));
        populator.addScript(new ClassPathResource("./dropAndCreate-CONTRACT.sql"));
        populator.addScript(new ClassPathResource("./insert-UPL_CRM_CLAIM.sql"));
        populator.addScript(new ClassPathResource("./insert-UPL_CRM_CLAIMCONTRACT.sql"));
        populator.addScript(new ClassPathResource("./insert-UPL_CRM_CLAIMROLE.sql"));
        populator.addScript(new ClassPathResource("./insert-CONTACT.sql"));
        populator.addScript(new ClassPathResource("./insert-CONTRACT.sql"));
        try {
            populator.populate(testH2DataSource.getConnection());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}