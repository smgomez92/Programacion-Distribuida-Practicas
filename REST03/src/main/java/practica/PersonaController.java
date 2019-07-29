package practica;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/Persona")
public class PersonaController {
	@GetMapping(path="/todas")
	public List<Persona> listar(){
		List<Persona> lista = new ArrayList<Persona>();
		lista.add(new Persona(1,"Santiago","gmail.com"));
		lista.add(new Persona(2,"Mauricio","gmail.com"));
		lista.add(new Persona(3,"Michu","gmail.com"));
		return lista;
	}
	@GetMapping(path="/saludo")
	public List<String> saludo(@RequestParam(value = "nombre", defaultValue = "Mundo")String nombre){
		List<String> lista = new ArrayList<String>();
		lista.add("Hola");
		lista.add(nombre);
		return lista;
		
	}

}
