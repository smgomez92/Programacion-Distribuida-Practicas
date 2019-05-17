package com.distribuida.servicios;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.distribuida.entidad.Persona;

public class MantenimientoImpl implements Mantenimiento {

	@Override
	public boolean insertar(Persona p, EntityManager em) {
		EntityTransaction trx = em.getTransaction();
		try {
			trx.begin();
			em.persist(p);
			trx.commit();
			return true;

		}

		catch (Exception e) {
			System.out.print(e);
			return false;

		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Persona> consultar(EntityManager em) {
		// TODO Auto-generated method stub
		return (List<Persona>)em.createQuery("SELECT p FROM Persona p").getResultList();
	}

	@Override
	public boolean borrar(Long id, EntityManager em) {
		EntityTransaction trx = em.getTransaction();
		System.out.println("BOOOORRAR");
		try {
			System.out.println("TRY");
			Persona p = em.find(Persona.class, id);
			trx.begin();
			em.remove(p);
			trx.commit();
			return true;
			
		}catch(NullPointerException e) {
			System.out.print("No se encontró la persona con el ID: "+id);
			return false;
			
		}
		
		
	}

	@Override
	public boolean actualizar(Persona p, EntityManager em) {
		try {
		em.getTransaction().begin();
		em.merge(p);
		em.getTransaction().commit();
		return true;
		
	}catch(NullPointerException e) {
		System.out.print("NO SE ACTUALIZÓ");
		return false;
		
	}
		
	}

	@Override
	public Persona getPersona(Long id, EntityManager em) {
		Persona p;
		try {
			p=em.find(Persona.class, id);
			return p;
		}catch(NullPointerException e) {
			System.out.print("No se encontró la persona con el ID: "+id);
			return null;
			
		}
		
		
		
	}

}
