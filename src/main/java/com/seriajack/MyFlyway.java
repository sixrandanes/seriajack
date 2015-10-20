package com.seriajack;

import javax.sql.DataSource;

import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.MigrationState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

@Configuration
@DependsOn("seriajackDataSource")
public class MyFlyway {

	@Autowired
	DataSource seriajackDataSource;

	@Bean(name = "flyway")
	public Flyway flyway() {
		Flyway flyway = new Flyway();
		flyway.setDataSource(seriajackDataSource);
		if (flyway.info() != null && flyway.info().current() != null
				&& MigrationState.FAILED.equals(flyway.info().current().getState())) {
			flyway.repair();
		}
		flyway.setOutOfOrder(true);
		flyway.migrate();
		return flyway;
	}

}
