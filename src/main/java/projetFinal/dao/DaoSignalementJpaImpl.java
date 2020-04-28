package projetFinal.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;


import projetFinal.context.Context;
import projetFinal.entity.Signalement;
import projetFinal.entity.SignalementObservation;
import projetFinal.entity.SignalementUtilisateur;

public class DaoSignalementJpaImpl implements DaoSignalement{

	@Override
	public void insert(Signalement obj) {
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
	public Signalement update(Signalement obj) {
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
	public void delete(Signalement obj) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.remove(em.merge(obj));
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
			em.remove(em.find(Signalement.class, key));
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
	public Optional<Signalement> findByKey(Integer key) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		Optional<Signalement> optional = Optional.ofNullable(em.find(Signalement.class, key));
		if (em != null && em.isOpen()) {
			em.close();
		}
		return optional;
	}

	@Override
	public List<Signalement> findAll() {
		List<Signalement> signalements = null;
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		Query query = em.createQuery("from Signalement s");
		signalements = query.getResultList();
		if (em != null && em.isOpen()) {
			em.close();
		}
		return signalements;
	}

	@Override
	public List<SignalementObservation> findAllSignalementObservation() {
		List<SignalementObservation> s_observations=null;
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		Query query = em.createQuery("from SignalementObservation so");
		s_observations = query.getResultList();
		if(em!=null && em.isOpen()) {
			em.close();
		}
		return s_observations;
		
	}

	@Override
	public List<SignalementUtilisateur> findAllSignalementUtilisateur() {
		List<SignalementUtilisateur> s_utilisateurs=null;
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		Query query = em.createQuery("from SignalementUtilisateur su");
		s_utilisateurs = query.getResultList();
		if(em!=null && em.isOpen()) {
			em.close();
		}
		return s_utilisateurs;
		
	}

}
