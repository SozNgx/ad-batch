package com.dimageshare.admage.batch.configuration.staging;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Setter
@Getter
@Configuration
@PropertySource("classpath:application-staging.yml")
@ConfigurationProperties("spring.second-datasource-staging.hikari")
@Profile("staging")
public class HikariSummaryDBProperty {
    private String poolName;

    private int minimumIdle;

    private int maximumPoolSize;

    private int idleTimeout;

    private long connectionTimeout;
}
