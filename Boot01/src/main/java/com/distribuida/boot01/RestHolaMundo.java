package com.distribuida.boot01;

//import org.omg.CORBA.Environment;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestHolaMundo {
	@Value("${mensaje.hola}")
	private String mensaje;
	@Value("${otro.chao}")
	private String mensaje_2;
	
	@Value("${server.port:8080}")
	private String puerto;
	@GetMapping(path = "/hola/{nombre}", produces = MediaType.APPLICATION_JSON_VALUE)
	public String hola(@PathVariable("nombre") String nombre) {
		return String.format("%s: %s, en el puerto: %s :%s", mensaje, nombre,puerto, mensaje_2);

	}
}
