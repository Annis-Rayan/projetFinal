package projetFinal.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import projetFinal.context.Context;
import projetFinal.entity.Localisation;

public class DaoLocalisationJpaImpl implements DaoLocalisation{

	@Override
	public void insert(Localisation obj) {
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
	public Localisation update(Localisation obj) {
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
	public void delete(Localisation obj) {
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
			em.remove(em.find(Localisation.class, key));
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
	public Optional<Localisation> findByKey(Integer key) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		Optional<Localisation> optional = Optional.ofNullable(em.find(Localisation.class, key));
		if (em != null && em.isOpen()) {
			em.close();
		}
		return optional;
	}

	@Override
	public List<Localisation> findAll() {
		List<Localisation> salles = null;
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		Query query = em.createQuery("from Salle s");
		salles = query.getResultList();
		if (em != null && em.isOpen()) {
			em.close();
		}
		return salles;
	}

}
