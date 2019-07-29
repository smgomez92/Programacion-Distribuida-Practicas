package com.prueba.boot;

//import java.io.PrintStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class BootPruebaApplication {
	private static Logger log = LoggerFactory.getLogger(BootPruebaApplication.class);
	@Value("${server.port}")
	String serverIp;
	@Value("${hola.mensaje}")
	String mensaje;
	@Value("${server.ip}")
	String ipServer;
	

	public static void main(String[] args) {

		SpringApplication app = new SpringApplication(BootPruebaApplication.class);
		// app.setBanner(new Banner() {
		// @Override
		// public void printBanner(Environment environment, Class<?> sourceClass,
		// PrintStream out) {
		// out.print("\t\t\t"+mensaje+"\t\t\t");
		// }

		// });
		app.run(args);
	}

	@Bean
	CommandLineRunner values() {
		return args -> {
			log.info(" > La Ip del servidor es: " + serverIp);
			log.info(" > mensaje: " + mensaje);
		};
	}

	@GetMapping(path = "/hola/{nombre}", produces = MediaType.APPLICATION_JSON_VALUE)
	public String hola(@PathVariable("nombre") String nombre) {
		return String.format("En el puerto: %s %s %s %s", nombre, serverIp,mensaje, serverIp);

	}

}
