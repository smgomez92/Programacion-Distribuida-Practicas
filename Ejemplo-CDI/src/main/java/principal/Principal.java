package principal;

import javax.enterprise.inject.Instance;
import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;

import servicios.HolaMundo;

public class Principal {

	public static void main(String[] args) {
		SeContainerInitializer init = SeContainerInitializer.newInstance();
	SeContainer container = init.initialize();
	
	Instance<HolaMundo> obj = container.select(HolaMundo.class);
	HolaMundo service = obj.get();
	
	String ret = service.hola("test");
	
	System.out.println(service.getClass().getName());
	System.out.println(ret);

	}

}

