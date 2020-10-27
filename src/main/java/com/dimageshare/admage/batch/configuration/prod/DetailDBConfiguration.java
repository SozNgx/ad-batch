package com.dimageshare.admage.batch.configuration.prod;

import com.dimageshare.admage.batch.configuration.common.HikariDetailDBDatasource;
import com.dimageshare.admage.batch.configuration.dev.HikariDetailDBProperty;
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
@ConfigurationProperties("spring.datasource-prod")
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "entityManagerFactoryDetail",
        transactionManagerRef = "transactionManagerDetail",
        basePackages = {"com.dimageshare.admage.batch.repository.detail"}
)
@Profile("prod")
public class DetailDBConfiguration extends HikariDetailDBDatasource {
    private final static String MODEL_PACKAGE = "com.dimageshare.admage.batch";

    public DetailDBConfiguration(HikariDetailDBProperty property) {
        super(property);
    }

    @Bean
    public HikariDataSource detailDataSource() {
        return new HikariDataSource(this);
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryDetail(
            final HikariDataSource detailDataSource) {

        return new LocalContainerEntityManagerFactoryBean() {{
            setDataSource(detailDataSource);
            setPersistenceProviderClass(HibernatePersistenceProvider.class);
            setPersistenceUnitName(PERSISTENCE_UNIT_NAME);
            setPackagesToScan(MODEL_PACKAGE);
            setJpaProperties(JPA_READ_PROPERTIES);
        }};
    }

    @Bean
    public PlatformTransactionManager transactionManagerDetail(EntityManagerFactory entityManagerFactoryDetail) {
        return new JpaTransactionManager(entityManagerFactoryDetail);
    }
}
