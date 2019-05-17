package com.distribuida.servicios;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ManejadorImpl implements Manejador{
	private EntityManagerFactory emf;
	private EntityManager em;

	@Override
	public EntityManager getManejador() {
		emf = Persistence.createEntityManagerFactory("openjpa");
		em=emf.createEntityManager();
		return em;
	}
	

}
