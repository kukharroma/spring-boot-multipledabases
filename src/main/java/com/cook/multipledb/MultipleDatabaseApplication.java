package com.cook.multipledb;

import com.cook.multipledb.config.DataSourcesProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({DataSourcesProperties.class})
public class MultipleDatabaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(MultipleDatabaseApplication.class, args);
	}

}
