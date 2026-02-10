package it.unipol.crm.attivita.batch.mapper;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.database.builder.JdbcPagingItemReaderBuilder;
import org.springframework.batch.item.database.support.SqlPagingQueryProviderFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
import java.util.Objects;

public class ColumnAnnotationRowMapperTestConfig {

    @Bean
    public ColumnAnnotationRowMapper<AllTypesModel> allTypesModelColumnAnnotationRowMapper(){
        return new ColumnAnnotationRowMapper<>(AllTypesModel.class);
    }

    @Bean
    public ItemReader<AllTypesModel> allTypesModelItemReader(@Qualifier("inputDataSource") DataSource inputDataSource,
                                                             ColumnAnnotationRowMapper<AllTypesModel> allTypesModelColumnAnnotationRowMapper) throws Exception {
        SqlPagingQueryProviderFactoryBean provider = new SqlPagingQueryProviderFactoryBean();
        provider.setDataSource(inputDataSource);
        provider.setSelectClause("select * ");
        provider.setFromClause("FROM ALL_TYPES_MODEL ");
        provider.setSortKey("BIG_INTEGER");

        return new JdbcPagingItemReaderBuilder<AllTypesModel>()
                .name("allTypesModelItemReader")
                .dataSource(inputDataSource)
                .queryProvider(Objects.requireNonNull(provider.getObject()))
                .rowMapper(allTypesModelColumnAnnotationRowMapper)
                .pageSize(1)
                .saveState(false)
                .build();
    }
}
