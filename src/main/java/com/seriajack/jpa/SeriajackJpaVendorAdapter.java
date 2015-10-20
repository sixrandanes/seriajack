package com.seriajack.jpa;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
public class SeriajackJpaVendorAdapter {

	@Bean
	@Primary
	@Profile("test")
	public JpaVendorAdapter jpaVendorAdapterSeriajackTest() {
		HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
		hibernateJpaVendorAdapter.setShowSql(false);
		hibernateJpaVendorAdapter.setGenerateDdl(true);
		hibernateJpaVendorAdapter.setDatabase(Database.H2);
		hibernateJpaVendorAdapter.setDatabasePlatform("org.hibernate.dialect.H2Dialect");
		return hibernateJpaVendorAdapter;
	}

	@Bean
	@Primary
	@Profile({ "local", "dev", "production" })
	public JpaVendorAdapter jpaVendorAdapterSeriajack() {
		HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
		hibernateJpaVendorAdapter.setShowSql(false);
		hibernateJpaVendorAdapter.setGenerateDdl(false);
		hibernateJpaVendorAdapter.setDatabase(Database.ORACLE);
		hibernateJpaVendorAdapter.setDatabasePlatform("org.hibernate.dialect.Oracle10gDialect");
		return hibernateJpaVendorAdapter;
	}

}
