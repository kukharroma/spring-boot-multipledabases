package com.cook.multipledb.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "data")
public class DataSourcesProperties {

    private List<DataSourceInfo> sources;

    private Map<String, String> strategies;

}
