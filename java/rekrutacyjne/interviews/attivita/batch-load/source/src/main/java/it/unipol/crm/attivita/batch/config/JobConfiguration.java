package it.unipol.crm.attivita.batch.config;

import it.unipol.crm.logger.batch.listeners.JobCompletionNotificationListener;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableBatchProcessing
public class JobConfiguration {

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public PlatformTransactionManager campagneTransactionManager;

    @Bean
    public Job loadAttivitaAndMcEventoJob(@Qualifier("loadAttivita") Step loadAttivita,
                                  JobCompletionNotificationListener listener) {
        return jobBuilderFactory
                .get("loadAttivitaAndMcEventoJob")
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .start(loadAttivita)
                .build();
    }
}
