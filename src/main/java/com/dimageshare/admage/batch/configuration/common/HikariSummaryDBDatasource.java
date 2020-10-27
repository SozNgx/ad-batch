package com.dimageshare.admage.batch.configuration.common;

import com.dimageshare.admage.batch.configuration.dev.HikariSummaryDBProperty;
import com.zaxxer.hikari.HikariConfig;

import java.util.Properties;

public class HikariSummaryDBDatasource extends HikariConfig {
    protected final HikariSummaryDBProperty summaryDBProperty;

    protected final String PERSISTENCE_UNIT_NAME = "summary";

    protected final Properties JPA_READ_PROPERTIES = new Properties() {{
        put("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
        put("hibernate.hbm2ddl.auto", "update");
        put("hibernate.ddl-auto", "update");
        put("show-sql", "true");
        put("hibernate.naming-strategy","org.hibernate.cfg.ImprovedNamingStrategy");
    }};

    protected HikariSummaryDBDatasource(HikariSummaryDBProperty summaryDBProperty) {
        this.summaryDBProperty = summaryDBProperty;
        setPoolName(this.summaryDBProperty.getPoolName());
        setMinimumIdle(this.summaryDBProperty.getMinimumIdle());
        setMaximumPoolSize(this.summaryDBProperty.getMaximumPoolSize());
        setIdleTimeout(this.summaryDBProperty.getIdleTimeout());
        setConnectionTimeout(this.summaryDBProperty.getConnectionTimeout());
    }
}
