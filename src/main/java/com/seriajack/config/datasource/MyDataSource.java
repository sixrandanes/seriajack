package com.seriajack.config.datasource;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;

@Configuration
public class MyDataSource {

	@Profile("production")
	@Bean(name = "seriajackDataSource")
	public DataSource seriajackDataSourceProd() {
		JndiDataSourceLookup dataSourceLookup = new JndiDataSourceLookup();
		DataSource dataSource = dataSourceLookup.getDataSource("jdbc/seriajack");
		return dataSource;
	}

	@Profile("local")
	@Bean(name = "seriajackDataSource")
	@ConfigurationProperties(prefix = "datasource.seriajack")
	public DataSource seriajackDataSourceLocal() {
		return DataSourceBuilder.create().build();
	}

	@Profile("dev")
	@Bean(name = "seriajackDataSource")
	@ConfigurationProperties(prefix = "datasource.seriajack")
	public DataSource seriajackDataSourceDev() {
		return DataSourceBuilder.create().build();
	}

	@Profile("test")
	@Bean(name = "seriajackDataSource")
	@ConfigurationProperties(prefix = "datasource.test")
	public DataSource seriajackDataSourceTest() {
		return DataSourceBuilder.create().build();
	}
}
