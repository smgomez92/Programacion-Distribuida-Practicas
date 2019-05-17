package com.openjpa.ejemplo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Testeo {
	// para operaciones CRUD
	private static EntityManager em;
	private static EntityManagerFactory emf;

	
	public static void main(String[] args) {
		System.out.print("MAIN");
		/* Se crea el gestor de persistencia */
		emf = Persistence.createEntityManagerFactory("openjpa");
		em = emf.createEntityManager();
		em.getTransaction().begin();
		
		//em.persist(new Persona(10L,"Santiago","San juan"));
		
		//List<Persona> persona = (List<Persona>) em.createQuery("SELECT p FROM Persona p").getResultList();
		
		Persona p = em.find(Persona.class, 11L);
		//p.setNombre("Michu");
		//em.merge(p);
		em.getTransaction().commit();
		//System.out.println("Hay "+persona.size()+" personas");
		System.out.println(p.toString());
	}

}
