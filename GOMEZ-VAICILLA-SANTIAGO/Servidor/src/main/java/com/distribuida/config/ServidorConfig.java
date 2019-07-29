package com.distribuida.config;

import java.sql.Connection;
import java.sql.DriverManager;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.distribuida.servicios")
public class ServidorConfig {
	@Bean
	public Connection dbConecction(String user, String contraseña) {
		Connection connection = null;
		try {
			Class.forName("org.postgresql.Driver");

			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Examen", user, contraseña);

		} catch (Exception ex) {
			System.out.println("Error al registrar el driver de PostgreSQL: " + ex);
			return null;
		}
		return connection;
	}
}
