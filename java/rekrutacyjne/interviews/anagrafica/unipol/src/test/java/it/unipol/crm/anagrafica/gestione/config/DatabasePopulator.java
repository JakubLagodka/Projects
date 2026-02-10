package it.unipol.crm.anagrafica.gestione.config;

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
    @Qualifier("anagraficaPersistenceDataSource")
    private DataSource testH2DataSource;

    public void populateAnagraficaDatabaseBeforeTestsInClass() {
        ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
        populator.addScript(new ClassPathResource("dropAndCreate-UPL_CRM_RECAPITI.sql"));
        populator.addScript(new ClassPathResource("dropAndCreate-UPL_CRM_OPTOUT.sql"));
        populator.addScript(new ClassPathResource("dropAndCreate-UPL_CRM_NUCLEI.sql"));
        populator.addScript(new ClassPathResource("dropAndCreate-UPL_CRM_NUCLEI_DETT.sql"));
        populator.addScript(new ClassPathResource("dropAndCreate-UPL_CRM_INDIRIZZI.sql"));
        populator.addScript(new ClassPathResource("dropAndCreate-UPL_CRM_DOCUMENTI.sql"));
        populator.addScript(new ClassPathResource("dropAndCreate-UPL_CRM_CONVENZIONI.sql"));
        populator.addScript(new ClassPathResource("dropAndCreate-UPL_CRM_ANAG_REL.sql"));
        populator.addScript(new ClassPathResource("dropAndCreate-UPL_CRM_ANOMALIE_ANAGRAFICHE.sql"));
        populator.addScript(new ClassPathResource("dropAndCreate-UPL_CRM_ANAGRAFICHE.sql"));
        populator.addScript(new ClassPathResource("dropAndCreate-UPL_CRM_ANAGRAFICHE_PF.sql"));
        populator.addScript(new ClassPathResource("dropAndCreate-UPL_CRM_ANAGRAFICHE_PG.sql"));
        populator.addScript(new ClassPathResource("dropAndCreate-UPL_CRM_ANAGRAFICA_AGENZIA.sql"));
        populator.addScript(new ClassPathResource("dropAndCreate-UPL_CRM_ANAGRAFICA_IDENTITA.sql"));
        populator.addScript(new ClassPathResource("dropAndCreate-UPL_CRM_DATI_SOCIOECONOMICI.sql"));
        populator.addScript(new ClassPathResource("dropAndCreate-UPL_CRM_DATI_SOCIOECONOMICI_PF.sql"));
        populator.addScript(new ClassPathResource("dropAndCreate-UPL_CRM_DATI_SOCIOECONOMICI_PF_ERRORI.sql"));

        populator.addScript(new ClassPathResource("insert-UPL_CRM_DATI_SOCIOECONOMICI_PF_ERRORI.sql"));
        populator.addScript(new ClassPathResource("insert-UPL_CRM_DATI_SOCIOECONOMICI_PF.sql"));
        populator.addScript(new ClassPathResource("insert-UPL_CRM_DATI_SOCIOECONOMICI.sql"));
        populator.addScript(new ClassPathResource("insert-UPL_CRM_ANAGRAFICA_IDENTITA.sql"));
        populator.addScript(new ClassPathResource("insert-UPL_CRM_ANAGRAFICA_AGENZIA.sql"));
        populator.addScript(new ClassPathResource("insert-UPL_CRM_ANAGRAFICHE_PG.sql"));
        populator.addScript(new ClassPathResource("insert-UPL_CRM_ANAGRAFICHE_PF.sql"));
        populator.addScript(new ClassPathResource("insert-UPL_CRM_ANAGRAFICHE.sql"));
        populator.addScript(new ClassPathResource("insert-UPL_CRM_ANOMALIE_ANAGRAFICHE.sql"));
        populator.addScript(new ClassPathResource("insert-UPL_CRM_ANAG_REL.sql"));
        populator.addScript(new ClassPathResource("insert-UPL_CRM_CONVENZIONI.sql"));
        populator.addScript(new ClassPathResource("insert-UPL_CRM_DOCUMENTI.sql"));
        populator.addScript(new ClassPathResource("insert-UPL_CRM_INDIRIZZI.sql"));
        populator.addScript(new ClassPathResource("insert-UPL_CRM_NUCLEI_DETT.sql"));
        populator.addScript(new ClassPathResource("insert-UPL_CRM_RECAPITI.sql"));
        populator.addScript(new ClassPathResource("insert-UPL_CRM_NUCLEI.sql"));
        populator.addScript(new ClassPathResource("insert-UPL_CRM_OPTOUT.sql"));
       try {
            populator.populate(testH2DataSource.getConnection());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}