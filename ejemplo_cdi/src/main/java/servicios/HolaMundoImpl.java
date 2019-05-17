package servicios;

import javax.enterprise.context.ApplicationScoped;

import jdk.jfr.Name;
@Name(value="hola")
@ApplicationScoped
public class HolaMundoImpl implements HolaMundo{
	
@Override 
	public String hola (String nombre) {
		
		return String.format("hola %s", nombre);
	}

}
