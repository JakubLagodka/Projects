package it.unipol.crm.attivita.batch.config;

import it.unipol.crm.attivita.batch.mapper.ColumnAnnotationRowMapper;
import it.unipol.crm.attivita.batch.model.WccAttivita;
import it.unipol.crm.attivita.batch.writer.WccAttivitaWriter;
import it.unipol.crm.logger.batch.listeners.TheCountStepListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.database.builder.JdbcPagingItemReaderBuilder;
import org.springframework.batch.item.database.support.SqlPagingQueryProviderFactoryBean;
import org.springframework.batch.item.support.PassThroughItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.task.TaskExecutorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.Objects;

@Slf4j
@Configuration
public class StepConfiguration {

    public static final String SELECT_ALL = "SELECT REQUEST_ID, COD_ISTITUTO, TIPO_OPERAZIONE, FLG_CARICATO, UPD_TIMESTAMP, " +
            "INS_TIMESTAMP, PROVENIENZA, ATTIVITA_ID, SISTEMA_ID, TIPOATTIVITA_ID, ATTIVITA_CLIENTE, CREATO_DA_TIPO, " +
            "CREATO_DA_UTENTE, CREATO_DA_NOMINATIVO, COMPAGNIA, AGENZIA_MADRE, AGENZIA_FIGLIA, CFPIVA_CLIENTE, CONT_ID, " +
            "CONTEXT_ID, REGOLA_ASSEGNAZIONE, PRIORITA, ATTIVITA_ST_TP_CD, AVVIO_DT, SCADENZA_DT, COMPLETATA_DT, FINE_DT, " +
            "RIAPERTURA, RIAPERTURA_DT, ESCALATION, ESCALATION_DT, ASSEGNATORE, ASSEGNATORE_DESC, ASSEGNAZIONE, ASSEGNATARIO, " +
            "ASSEGNATARIO_DESC, FLAG_ANNOTAZIONE, ANNOTAZIONE, CHIUSA_SCADUTA, LAST_UPDATE_DT, DELEGA_CC, DELEGA_CC_ABILITATA, " +
            "GESTIONE_MC, ID_PROCESSO, INDICATORE_ICONA, DELEGA_CC_INIZIALE";
    public static final String FLG_CARICATO_EQ_0 = "WHERE FLG_CARICATO = 0";
    public static final String REQUEST_ID = "REQUEST_ID";

    @Value("${BATCH_POOL_SIZE}")
    private int batchPoolSize;

    @Value("${CHUNK_SIZE:50}")
    private int chunkSize;

    @Value("${PAGE_SIZE:50}")
    private int pageSize;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Autowired
    public TheCountStepListener theCountStepListener;

    @Autowired
    public PlatformTransactionManager attivitaTransactionManager;

    @Bean
    @JobScope
    public ThreadPoolTaskExecutor stepsTaskExecutor() {
        ThreadPoolTaskExecutor executor = new TaskExecutorBuilder()
                .corePoolSize(batchPoolSize)
                .maxPoolSize(batchPoolSize)
                .build();

        executor.initialize();
        return executor;
    }

    @Bean
    public ItemReader<WccAttivita> wccAttivitaItemReader(@Qualifier("inputDataSource") DataSource inputDataSource) throws Exception {
        SqlPagingQueryProviderFactoryBean provider = new SqlPagingQueryProviderFactoryBean();
        provider.setDataSource(inputDataSource);
        provider.setSelectClause(SELECT_ALL);
        provider.setFromClause("FROM WCC_ATTIVITA");
        provider.setWhereClause(FLG_CARICATO_EQ_0);
        provider.setSortKey(REQUEST_ID);

        return new JdbcPagingItemReaderBuilder<WccAttivita>()
                .name("wccAttivitaItemReader")
                .dataSource(inputDataSource)
                .queryProvider(Objects.requireNonNull(provider.getObject()))
                .rowMapper(new ColumnAnnotationRowMapper<>(WccAttivita.class))
                .pageSize(pageSize)
                .saveState(false)
                .build();
    }

    @Bean
    public PassThroughItemProcessor<WccAttivita> wccAttivitaPassThroughItemProcessor() {
        return new PassThroughItemProcessor<>();
    }

    @Bean
    public Step loadAttivita(ItemReader<WccAttivita> wccAttivitaItemReader,
                             PassThroughItemProcessor<WccAttivita> wccAttivitaPassThroughItemProcessor,
                             WccAttivitaWriter wccAttivitaWriter,
                             TaskExecutor stepsTaskExecutor){

        log.info("Creating step loadAttivita with pageSize = {} and chunkSize = {}", pageSize, chunkSize);

        return stepBuilderFactory
                .get("loadAttivita")
                .transactionManager(attivitaTransactionManager)
                .listener(theCountStepListener)
                .<WccAttivita, WccAttivita>chunk(chunkSize)
                .reader(wccAttivitaItemReader)
                .processor(wccAttivitaPassThroughItemProcessor)
                .writer(wccAttivitaWriter)
                .faultTolerant()
                .taskExecutor(stepsTaskExecutor)
                .throttleLimit(batchPoolSize)
                .build();
    }

}
