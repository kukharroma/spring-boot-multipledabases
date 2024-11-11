package com.cook.multipledb.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Configuration
public class MultipleDataSourceConfig {

    private final DataSourcesProperties dataSourcesProperties;

    @Autowired
    public MultipleDataSourceConfig(DataSourcesProperties dataSourcesProperties) {
        this.dataSourcesProperties = dataSourcesProperties;
    }

    @Bean
    public Map<String, DataSource> dataSourcesMap() {
        return dataSourcesProperties.getSources().stream()
                .collect(Collectors.toMap(
                        DataSourceInfo::name, this::createDataSource
                ));
    }

    @Bean
    public Map<String, JdbcTemplate> jdbcTemplateMap(Map<String, DataSource> dataSourcesMap) {
        return dataSourcesMap.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> new JdbcTemplate(entry.getValue())
                ));
    }

    private DataSource createDataSource(DataSourceInfo config) {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(config.url());
        dataSource.setUsername(config.user());
        dataSource.setPassword(config.password());
        dataSource.setDriverClassName(determineDriverClass(config.strategy()));
        return dataSource;
    }

    private String determineDriverClass(String strategy) {
        return Optional.ofNullable(dataSourcesProperties.getStrategies().get(strategy))
                .orElseThrow(() -> new IllegalArgumentException("Unsupported strategy: " + strategy));
    }

}
