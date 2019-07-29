package com.practica.config;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan(basePackages="com.practica.servicios")
public class ConfigJDBC {
	@Bean(name="DataSource")
	public JdbcTemplate dataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		String driverClassName = "org.postgresql.Driver";
		String url = "jdbc:postgresql://localhost:5432/Spring";
		String username = "postgres";
		String password = "admin";		
		ds.setDriverClassName(driverClassName);
		ds.setUrl(url);
		ds.setUsername(username);
		ds.setPassword(password);
		return new JdbcTemplate(ds);
	}
}
