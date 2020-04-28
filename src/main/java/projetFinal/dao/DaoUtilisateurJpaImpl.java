package projetFinal.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;


import projetFinal.context.Context;
import projetFinal.entity.Utilisateur;

public class DaoUtilisateurJpaImpl implements DaoUtilisateur {

	@Override
	public void insert(Utilisateur obj) {
		EntityManager em = Context.getEntityMangerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.persist(obj);
			tx.commit();
		}catch(Exception e) {
			if(tx!=null && tx.isActive()) {
				tx.rollback();
				e.printStackTrace();
			}
		}
		if(em!=null && em.isOpen()) {
			em.close();
		}
	}

	@Override
	public Utilisateur update(Utilisateur obj) {
		EntityManager em = Context.getEntityMangerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			obj = em.merge(obj);
			tx.commit();
		}catch(Exception e) {
			e.printStackTrace();
			if(tx!=null && tx.isActive()) {
				tx.rollback();
				
			}
		}
		if(em!=null && em.isOpen()) {
			em.close();
		}
		return obj;
		
	}

	@Override
	public void delete(Utilisateur obj) {
		EntityManager em = Context.getEntityMangerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.remove(em.merge(obj));
			tx.commit();
		}catch (Exception e) {
			e.printStackTrace();
			if(tx!=null && tx.isActive()) {
				tx.rollback();
				
			}
		}
		if(em!=null && em.isOpen()) {
			em.close();
		}
		
	}

	@Override
	public void deleteByKey(Integer key) {
		EntityManager em = Context.getEntityMangerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.remove(em.find(Utilisateur.class, key));
			tx.commit();
		}catch (Exception e) {
			e.printStackTrace();
			if(tx!=null && tx.isActive()) {
				tx.rollback();
				
			}
		}
		if(em!=null && em.isOpen()) {
			em.close();
		}
		
	}

	@Override
	public Optional<Utilisateur> findByKey(Integer key) {
		
		return null;
	}

	@Override
	public List<Utilisateur> findAll() {
		
		return null;
	}

}
