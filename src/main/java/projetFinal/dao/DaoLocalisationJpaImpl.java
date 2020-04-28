package projetFinal.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import formationJpa.context.Context;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Localisation obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteByKey(Integer key) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Optional<Localisation> findByKey(Integer key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Localisation> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
