package servicios;

import javax.inject.Named;



@Named(value="servicio")
public class HolaMundoImpl implements HolaMundo {
	@Override
	public String hola(String nombre) {
		return String.format("Hola %s", nombre);

	}
}
