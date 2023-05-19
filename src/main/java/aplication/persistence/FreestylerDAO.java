package aplication.persistence;


import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
 

import aplication.model.Freestyler;
import aplication.utils.JPAUtil;
 
 

public class FreestylerDAO {

	 
		
	public void insertarFreestylerJPA(Freestyler freestyler) {
				
		//JPA
	    EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
		try {
		em.getTransaction().begin();
		em.persist(freestyler);
		em.getTransaction().commit();
		}
		catch(PersistenceException e) {
			em.getTransaction().rollback();
			System.out.println(e.getMessage());
		}
		finally {
			em.close();
		}
		 
		
		
	}
	
	 
		
	
	public void modificarFreestylerJPA(Freestyler freestyler) {
		
		//JPA
		EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
		try {
		em.getTransaction().begin();
		em.merge(freestyler);
		em.getTransaction().commit();
		}
		catch(PersistenceException e) {
			em.getTransaction().rollback();
			System.out.println(e.getMessage());
		}
		finally {
			em.close();
		}
		
	}
	
	 
		
	public void eliminarFreestylerJPA(Freestyler freestyler) {
		
		//JPA
		EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
		try {
		em.getTransaction().begin();
		
		em.remove(em.contains(freestyler)? freestyler:em.merge(freestyler) );
		
		em.getTransaction().commit();
		}
		catch(PersistenceException e) {
			em.getTransaction().rollback();
			System.out.println(e.getMessage());
		}
		finally {
			em.close();
		}
				
	}
	
	 
		
	public ArrayList<Freestyler> listarFreestylerJPA() {
		
		EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			
			ArrayList<Freestyler> misFreestylers= (ArrayList<Freestyler>) em.createQuery("from Freestyler").getResultList();
			em.getTransaction().commit();
			return misFreestylers;
			
			}
			catch(PersistenceException e) {
				em.getTransaction().rollback();
				System.out.println(e.getMessage());
			}
			finally {
				em.close();
			}
		
		return null;
		
	}
	
	
	
	
	
	 
	
	public Freestyler buscarFreestylerPorIdJPA(int id) {
		
		EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			Freestyler freestyler = em.find(Freestyler.class, id);
			System.out.println("El Freestyler buscado se llama :"+freestyler.getNombre());
			return freestyler;
			}
			catch(PersistenceException e) {
				em.getTransaction().rollback();
				System.out.println(e.getMessage());
			}
			finally {
				em.close();
			}
			return null;		
	}
	
	
	
	public void imprimirFreestyler(ArrayList<Freestyler> misFreestylers) {
		System.out.println("Listado de Freestyler");
		for(Freestyler a:misFreestylers) {
			a.toString();
		}
	}
	
}
