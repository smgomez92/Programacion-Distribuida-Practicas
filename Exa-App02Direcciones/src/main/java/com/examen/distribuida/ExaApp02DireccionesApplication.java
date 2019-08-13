package com.examen.distribuida;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@SpringBootApplication
@RefreshScope //Anotación para actualizar las propiedades si estas han sido alteradas en el server config
//@EnableDiscoveryClient 
public class ExaApp02DireccionesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExaApp02DireccionesApplication.class, args);
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
