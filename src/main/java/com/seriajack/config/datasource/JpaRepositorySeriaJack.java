package com.seriajack.config.datasource;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableJpaRepositories(basePackages = "com.seriajack", entityManagerFactoryRef = "seriajackEntityManagerFactory", transactionManagerRef = "seriajackTransactionManager")
public class JpaRepositorySeriaJack {

	@Autowired
	private DataSource seriajackDataSource;

	@Autowired
	private JpaVendorAdapter seriajackJpaVendorAdapter;

	@Bean(name = "seriajackEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean seriajackEntityManagerFactory() throws Throwable {

		LocalContainerEntityManagerFactoryBean entityManager = new LocalContainerEntityManagerFactoryBean();

		entityManager.setDataSource(seriajackDataSource);
		entityManager.setPackagesToScan("com.seriajack");
		entityManager.setPersistenceUnitName("seriajack");
		entityManager.setJpaVendorAdapter(seriajackJpaVendorAdapter);
		return entityManager;
	}

	@Bean
	public PlatformTransactionManager seriajackTransactionManager() throws Throwable {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(seriajackEntityManagerFactory().getObject());
		return transactionManager;
	}
}
