package com.recuperacion.repositorio;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.recuperacion.modelo.Persona;
@Stateless
public class RepoPersonaImpl implements RepoPersona {
	@PersistenceContext(unitName = "suplePU")
	private EntityManager em;

	@Override
	public void persist(Persona persona) {
		em.persist(persona);
		
	}

	@Override
	public void update(Persona persona) {
		em.merge(persona);
		
	}

	@Override
	public void delete(Persona persona) {
		
		try {
			em.remove(persona);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Persona> list() {
		List<Persona> lista = new ArrayList<>();
		try {
			Query query = em.createQuery("SELECT p FROM Persona p");

			lista = (List<Persona>) query.getResultList();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return lista;
	}

	@Override
	public Persona findById(Integer id) {
		TypedQuery<Persona> q2 = em.createQuery("SELECT persona FROM persona p where id =?1", Persona.class);
		q2.setParameter(1, id);
		return q2.getSingleResult();
	}

}
