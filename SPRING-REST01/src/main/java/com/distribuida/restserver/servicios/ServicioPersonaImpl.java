package com.distribuida.restserver.servicios;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.distribuida.restserver.dto.Persona;

@Component
public class ServicioPersonaImpl implements ServicioPersona {
	/**
	 * Bloque de inicialización de la data
	 * 
	 */
	private static List<Persona> personas = new ArrayList<Persona>();
	static {
		personas.add(new Persona(1, "Santiago"));
		personas.add(new Persona(2, "Mauricio Gómez"));
		personas.add(new Persona(3, "Michu"));
		personas.add(new Persona(4, "Cuarto"));
	}

	@Override
	public Persona buscar(int id) {
		for (Persona p : personas) {
			if (p.getId() == id) {
				return p;

			}

		}
		return null;
	}

	@Override
	public Persona crear(Persona p) {
		personas.add(p);
		return p;
	}

	@Override
	public void eliminar(int id) {
		int c =0;
		for(Persona p : personas) {
			if(p.getId()==id) {
				personas.remove(c);
				break;
			}
			c++;
		}

	}

	@Override
	public Persona editar(Persona p) {
		int c =0;
		for(Persona p1 : personas) {
			if(p1.getId()==p.getId()) {
				personas.get(c).setNombre(p.getNombre());
				return p;
			}
			c++;
		}
		return null;
	}

	@Override
	public List<Persona> listar() {
		
		return personas;
	}
}
