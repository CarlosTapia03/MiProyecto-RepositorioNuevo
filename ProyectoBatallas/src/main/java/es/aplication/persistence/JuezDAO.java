package es.aplication.persistence;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import es.aplication.entities.Juez;
import es.aplication.utils.JPAUtil;
 
 

public class JuezDAO {

	
	 
		
	public void insertarJuezJPA(Juez juez) {
				
		//JPA
	    EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
		try {
		em.getTransaction().begin();
		em.persist(juez);
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
	
	 
		
	
	public void modificarJuezJPA(Juez juez) {
		
		//JPA
		EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
		try {
		em.getTransaction().begin();
		em.merge(juez);
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
	
 
		
	public void eliminarJuezJPA(Juez juez) {
		
		//JPA
		EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
		try {
		em.getTransaction().begin();
		
		em.remove(em.contains(juez)? juez:em.merge(juez) );
		
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
	
 
	
	 
	
	public Juez buscarPorIdJPA(Integer id) {
		
		EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			Juez juez = em.find(Juez.class, id);
			System.out.println("El juez buscado se llama :"+juez.getNombre());
			return juez;
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
	
	
	public ArrayList<Juez> listarJuezsJPA() {
		
		EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			
			ArrayList<Juez> misJuezs = (ArrayList<Juez>) em.createQuery("from Juez").getResultList();
			em.getTransaction().commit();
			return misJuezs;
			
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
	public void imprimirJuezs(ArrayList<Juez> misjuezs) {
		System.out.println("Listado de Jueces");
		for(Juez a:misjuezs) {
			System.out.println(a.toString());
		}
	}
	
}
