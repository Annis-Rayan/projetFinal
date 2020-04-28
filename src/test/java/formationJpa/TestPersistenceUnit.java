package formationJpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import formationJpa.context.Context;
import formationJpa.entity.Personne;


public class TestPersistenceUnit {
	public static void main (String[] args) {
//		EntityManagerFactory emf = Context.getEntityMangerFactory();
//		
//		EntityManager em = null;
//		Personne olivier = new Personne();
//		olivier.setId(1);
//		olivier.setPrenom("olivier");
//		
//		em = emf.createEntityManager();
//		
//		EntityTransaction tx = em.getTransaction();//permet d'effectuer la transaction qui va permettre ensuite le commit
//		tx.begin();
//		em.persist(olivier);
//		olivier.setNom("gozlan");
//		olivier.setPrenom("oooo");
//		
//		tx.commit();
//		em.close();
//		
//		//cette nouvelle modif nécessite une nouvelle transaction car en dehors de la précédente.
//		
//		olivier.setPrenom("apres commit");
//		em = Context.getEntityMangerFactory().createEntityManager();
//		tx = em.getTransaction();
//		tx.begin();
//		olivier.setId(5);
//		Personne p = em.merge(olivier);// si l'objet existe déjà, il fait un update. Sinon, il fait un create
//		p.setNom("apres merge");
//		tx.commit();
//		em.close();
//		
//		em = Context.getEntityMangerFactory().createEntityManager(); //pour faire un find
//		Personne recherche = em.find(Personne.class, 1);
//		System.out.println(recherche);
//		tx = em.getTransaction();
//		tx.begin();
//		em.remove(recherche); //pour delete la ligne correspondante dans la table. L'objet référence (ici recherche) existe toujours
//		tx.commit();
//		em.close();
//		
//		
//		Context.destroy();
	}
}
