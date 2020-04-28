package projetFinal.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import projetFinal.context.Context;
import projetFinal.entity.Animal;


public class DaoAnimalJpaImpl implements DaoAnimal{

	@Override
	public void insert(Animal obj) {
		EntityManager em=Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx=em.getTransaction();
		try {
			tx.begin();
			em.persist(obj);
			tx.commit();
		} catch (Exception e) {
			if(tx!=null&& tx.isActive()) {
			tx.rollback();//annule la transaction
			}
		}
		em.close();
		
		
	}

	@Override
	public Animal update(Animal obj) {
		EntityManager em=Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx=em.getTransaction();
		try {
			tx.begin();
			obj=em.merge(obj);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if(tx!=null&& tx.isActive()) {
			tx.rollback();//annule la transaction
			}
		}
		if(em!=null &&tx.isActive()) {
		em.close();
		}
		return obj;
	}

	@Override
	public void delete(Animal obj) {
		EntityManager em=Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx=em.getTransaction();
		try {
			tx.begin();
			em.remove(em.merge(obj));
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if(tx!=null&& tx.isActive()) {
			tx.rollback();//annule la transaction
			}
		}
		if(em!=null &&tx.isActive()) {
		em.close();
		
		}
		
	}

	@Override
	public void deleteByKey(Integer key) {
		EntityManager em=Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx=em.getTransaction();
		try {
			tx.begin();
			em.remove(em.find(Animal.class,key));
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if(tx!=null&& tx.isActive()) {
			tx.rollback();//annule la transaction
			}
		}
		if(em!=null &&tx.isActive()) {
		em.close();
		}
		
	}

	@Override
	public Optional<Animal> findByKey(Integer key) {
		EntityManager em=Context.getEntityManagerFactory().createEntityManager();
		Optional<Animal> optional=Optional.ofNullable(em.find(Animal.class, key));
		if(em!=null && em.isOpen()) {
			em.close();
		}
		return optional;
	}

	@Override
	public List<Animal> findAll() {
		List<Animal> formations =null;
		EntityManager em=Context.getEntityManagerFactory().createEntityManager();
		Query query=em.createQuery("from Animal a");
		formations=query.getResultList();
		
		if(em!=null && em.isOpen()) {
			em.close();
		}
	
		
		return formations;
	}



	@Override
	public Optional<Animal> findByNomScientifique(String nomScientifique) {
		EntityManager em=Context.getEntityManagerFactory().createEntityManager();
		Optional<Animal> optional=Optional.ofNullable(em.find(Animal.class, nomScientifique));
		if(em!=null && em.isOpen()) {
			em.close();
		}
		return optional;
	}

	@Override
	public Optional<Animal> findByNomCourant(String nomCourant) {
		EntityManager em=Context.getEntityManagerFactory().createEntityManager();
		Optional<Animal> optional=Optional.ofNullable(em.find(Animal.class, nomCourant));
		if(em!=null && em.isOpen()) {
			em.close();
		}
		return optional;
	}

}
