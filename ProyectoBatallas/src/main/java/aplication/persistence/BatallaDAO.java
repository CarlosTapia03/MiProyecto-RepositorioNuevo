package aplication.persistence;



import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
 
import aplication.model.Batalla;
import aplication.utils.JPAUtil;
 
 

public class BatallaDAO {
 
		
	public void insertarBatallaJPA(Batalla batalla) {
				
		//JPA
	    EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
		try {
		em.getTransaction().begin();
		em.persist(batalla);
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
	
	 
	
	public void modificarBatallaJPA(Batalla batalla) {
		
		//JPA
		EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
		try {
		em.getTransaction().begin();
		em.merge(batalla);
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
	
	 
		
	public void eliminarBatallaJPA(Batalla batalla) {
		
		//JPA
		EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
		try {
		em.getTransaction().begin();
		
		em.remove(em.contains(batalla)? batalla:em.merge(batalla) );
		
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
	
	 
		
	public ArrayList<Batalla> listarBatallaJPA() {
		
		EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			
			ArrayList<Batalla> misBatallas = (ArrayList<Batalla>) em.createQuery("from Batalla").getResultList();
			em.getTransaction().commit();
			return misBatallas;
			
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
	
	
	 
		
	
	public Batalla buscarBatallaPorIdJPA(int id) {
		
		EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			Batalla batalla = em.find(Batalla.class, id);
			System.out.println("La Batalla buscada es :"+batalla.getId());
			return batalla;
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
	
	
	
	public void imprimirBatallas(ArrayList<Batalla> misBatallas) {
		System.out.println("Listado de Batallas");
		for(Batalla a:misBatallas) {
			a.toString();
		}
	}
	
}
