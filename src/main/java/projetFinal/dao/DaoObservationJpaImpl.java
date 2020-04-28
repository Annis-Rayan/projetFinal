package projetFinal.dao;

import java.util.List;
import java.util.Optional;


import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import projetFinal.context.Context;
import projetFinal.entity.Observation;

class DaoObservationJpaImpl implements DaoObservation{

	@Override
	public void insert(Observation obj) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.persist(obj);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		}
		if (em != null && em.isOpen()) {
			em.close();
		}
		
	}

	@Override
	public Observation update(Observation obj) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			obj = em.merge(obj);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		}
		if (em != null && em.isOpen()) {
			em.close();
		}
		return obj;
	}

	@Override
	public void delete(Observation obj) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			Observation observation = em.find(Observation.class, obj.getId());
		//	Observation observation = em.merge(obj);
			//if (!observation.getStagiaires().isEmpty()) {
			//	for (Stagiaire stagiaire : formation.getStagiaires()) {
					// suppression en cascade
					// em.remove(stagiaire);
			//		stagiaire.setFormation(null);
			//	}
			//}
			em.remove(observation);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		}
		if (em != null && em.isOpen()) {
			em.close();
		}
		
	}

	@Override
	public void deleteByKey(Integer key) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.remove(em.find(Observation.class, key));
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		}
		if (em != null && em.isOpen()) {
			em.close();
		}
		
	}

	@Override
	public List<Observation> findAll() {
		List<Observation> observations = null;
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		// Query query = em.createQuery("from Formation f");
		Query query = em.createNamedQuery("Formation.findAll");
		observations = query.getResultList();
		if (em != null && em.isOpen()) {
			em.close();
		}
		return observations;
	}

	@Override
	public List<Observation> findByAnimal(String animal) {
		List<Observation> observations = null;
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		Query query = em.createNamedQuery("Formation.findByNom");
		query.setParameter("animal", animal);
		observations = query.getResultList();
		if (em != null && em.isOpen()) {
			em.close();
		}
		return observations;
	}

	@Override
	public List<Observation> findByUtilisateur(String utilisateur) {
		List<Observation> observations = null;
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		Query query = em.createNamedQuery("Formation.findByNom");
		query.setParameter("utilisateur", utilisateur);
		observations = query.getResultList();
		if (em != null && em.isOpen()) {
			em.close();
		}
		return observations;
	}

	@Override
	public List<Observation> findByLocalisation(String localisation) {
		List<Observation> observations = null;
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		Query query = em.createNamedQuery("Formation.findByNom");
		query.setParameter("localisation", localisation);
		observations = query.getResultList();
		if (em != null && em.isOpen()) {
			em.close();
		}
		return observations;
	}

	@Override
	public Optional<Observation> findByKey(Integer key) {
		Observation observation = null;
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		Query query = em.createNamedQuery("Formation.findByKeyWithStagiaires");
		query.setParameter("id", key);
		try {
			observation = (Observation) query.getSingleResult();
		} catch (NoResultException e) {

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (em != null && em.isOpen()) {
			em.close();
		}
		return Optional.ofNullable(observation);
	}

}
