package com.dimageshare.admage.batch.configuration.dev;

import com.dimageshare.admage.batch.configuration.common.HikariSummaryDBDatasource;
import com.zaxxer.hikari.HikariDataSource;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;

@Configuration
@ConfigurationProperties("spring.second-datasource-dev")
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "entityManagerFactorySummary",
        transactionManagerRef = "transactionManagerSummary",
        basePackages = {"com.dimageshare.admage.batch.repository.summary"}
)
@Profile("dev")
public class SummaryDBConfiguration extends HikariSummaryDBDatasource {
    private final static String MODEL_PACKAGE = "com.dimageshare.admage.batch";

    public SummaryDBConfiguration(HikariSummaryDBProperty property) {
        super(property);
    }

    @Bean
    public HikariDataSource summaryDataSource() {
        return new HikariDataSource(this);
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactorySummary(
            final HikariDataSource summaryDataSource) {

        return new LocalContainerEntityManagerFactoryBean() {{
            setDataSource(summaryDataSource);
            setPersistenceProviderClass(HibernatePersistenceProvider.class);
            setPersistenceUnitName(PERSISTENCE_UNIT_NAME);
            setPackagesToScan(MODEL_PACKAGE);
            setJpaProperties(JPA_READ_PROPERTIES);
        }};
    }

    @Bean
    public PlatformTransactionManager transactionManagerSummary(EntityManagerFactory entityManagerFactorySummary) {
        return new JpaTransactionManager(entityManagerFactorySummary);
    }
}
