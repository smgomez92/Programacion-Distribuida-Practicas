package com.hibernate.main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.hibernate.entity.Persona;

public class Testeo {
	// para operaciones CRUD
	private static EntityManager em;
	private static EntityManagerFactory emf;

	
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		System.out.println("MAIN");
		/* Se crea el gestor de persistencia */
		emf = Persistence.createEntityManagerFactory("persistencia");
		em = emf.createEntityManager();
		em.getTransaction().begin();
		//em.persist(new Persona(10L,"Santiago","San juan"));
		
		List<Persona> persona = (List<Persona>) em.createQuery("FROM Persona").getResultList();		
		System.out.println("Hay "+persona.size()+" personas");
		System.out.println(persona.get(0));
		Persona p = new Persona();
		p=em.find(Persona.class, 10L);
		System.out.print(p.getNombre());
		em.getTransaction().commit();
		
		
	}

}
