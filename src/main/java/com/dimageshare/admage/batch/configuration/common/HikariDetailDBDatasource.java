package com.dimageshare.admage.batch.configuration.common;

import com.dimageshare.admage.batch.configuration.dev.HikariDetailDBProperty;
import com.zaxxer.hikari.HikariConfig;

import java.util.Properties;

public class HikariDetailDBDatasource extends HikariConfig {
    protected final HikariDetailDBProperty detailDBProperty;

    protected final String PERSISTENCE_UNIT_NAME = "detail";

    protected final Properties JPA_READ_PROPERTIES = new Properties() {{
        put("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
        put("hibernate.hbm2ddl.auto", "update");
        put("hibernate.ddl-auto", "update");
        put("show-sql", "true");
        put("hibernate.naming-strategy","org.hibernate.cfg.ImprovedNamingStrategy");
    }};

    protected HikariDetailDBDatasource(HikariDetailDBProperty detailDBProperty) {
        this.detailDBProperty = detailDBProperty;
        setPoolName(this.detailDBProperty.getPoolName());
        setMinimumIdle(this.detailDBProperty.getMinimumIdle());
        setMaximumPoolSize(this.detailDBProperty.getMaximumPoolSize());
        setIdleTimeout(this.detailDBProperty.getIdleTimeout());
        setConnectionTimeout(this.detailDBProperty.getConnectionTimeout());
    }
}

