package com.prueba.distribuida;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@SpringBootApplication
@EnableDiscoveryClient
public class PruebaApp02Application {

	public static void main(String[] args) {
		SpringApplication.run(PruebaApp02Application.class, args);
	}

	@Value("${db.driverClassName}")
	String driverClassName;
	@Value("${db.url}")
	String url;
	@Value("${db.username}")
	String username;
	@Value("${db.password}")
	String password;
	
	@Bean(name="DataSource")	
	public JdbcTemplate dataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName(driverClassName);
		ds.setUrl(url);
		ds.setUsername(username);
		ds.setPassword(password);
		return new JdbcTemplate(ds);
	}
	
	
}
