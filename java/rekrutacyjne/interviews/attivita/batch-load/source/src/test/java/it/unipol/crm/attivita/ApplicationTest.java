package it.unipol.crm.attivita;

import it.unipol.crm.attivita.batch.model.WccAttivitaRepository;
import it.unipol.crm.attivita.persistence.entity.attivita.UplCrmAttivita;
import it.unipol.crm.attivita.persistence.entity.attivita.UplCrmAttivitaRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.ConfigDataApplicationContextInitializer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.util.List;

import static org.junit.Assert.*;

@ContextConfiguration(classes = {Application.class},
        initializers = ConfigDataApplicationContextInitializer.class)
@RunWith(SpringRunner.class)
public class ApplicationTest {

    @Value("${BATCH_DB_UPDATE_USER}")
    protected String BATCH_DB_UPDATE_USER;

    @Autowired
    @Qualifier("inputDataSource")
    private DataSource inputDataSource;

    @Autowired
    @Qualifier("attivitaPersistenceDataSource")
    private DataSource attivitaPersistenceDataSource;

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    @Qualifier("loadAttivitaAndMcEventoJob")
    private Job loadAttivitaAndMcEventoJob;

    @Autowired
    private WccAttivitaRepository wccAttivitaRepository;

    @Autowired
    private UplCrmAttivitaRepository uplCrmAttivitaRepository;

    @Test
    public void shouldBatchRunCompleted() throws JobInstanceAlreadyCompleteException, JobExecutionAlreadyRunningException, JobParametersInvalidException, JobRestartException {

        ResourceDatabasePopulator inputPopulator = new ResourceDatabasePopulator();
        inputPopulator.addScript(new ClassPathResource("/db/createWccAttivitaTable.sql"));
        inputPopulator.addScript(new ClassPathResource("/db/insertIntoWccAttivita.sql"));
        DatabasePopulatorUtils.execute(inputPopulator, inputDataSource);

        ResourceDatabasePopulator inputPopulator2 = new ResourceDatabasePopulator();
        inputPopulator2.addScript(new ClassPathResource("/db/createUplCrmAttivitaTable.sql"));
        inputPopulator2.addScript(new ClassPathResource("/db/createTipoAttivitaTable.sql"));
        inputPopulator2.addScript(new ClassPathResource("/db/insertIntoUplCrmAttivita.sql"));
        inputPopulator2.addScript(new ClassPathResource("/db/insertIntoUplCrmTippoAttivita.sql"));
        DatabasePopulatorUtils.execute(inputPopulator2, attivitaPersistenceDataSource);

        JobParameters params = new JobParametersBuilder()
                .addString("JobID", String.valueOf(System.currentTimeMillis()))
                .toJobParameters();

        String result = jobLauncher.run(loadAttivitaAndMcEventoJob, params).
                getExitStatus().getExitCode();

        Assert.assertEquals("COMPLETED",
                result);

        wccAttivitaRepository.findAll()
                .forEach(att -> {
                    assertEquals(Integer.valueOf(2), att.getFlgCaricato());
                    assertNotNull(att.getAttivitaId());
                });

        List<UplCrmAttivita> allAttivitas = uplCrmAttivitaRepository.findAll();
        assertEquals(1, allAttivitas.size());
        allAttivitas.forEach(cam -> {
            assertEquals(BATCH_DB_UPDATE_USER, cam.getLastUpdateUser());
            assertNotNull(cam.getLastUpdateDt());
            assertNull("Id processo should be null when not provided.", cam.getIdProcesso());
        });

    }

}