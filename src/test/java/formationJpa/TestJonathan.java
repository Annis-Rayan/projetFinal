package formationJpa;

import projetFinal.dao.DaoObservation;
import projetFinal.dao.DaoObservationFactory;
import projetFinal.entity.Observation;

public class TestJonathan {
	public static void main(String[] args) {
		Observation obs = new Observation();
		System.out.println("-----------------------------------");
		DaoObservation daoObservation=DaoObservationFactory.getInstance();
		System.out.println("-----------------------------------");
		
		obs.setNombre(2);		
		obs.setId(100);
		System.out.println("-----------------------------------");

		daoObservation.insert(obs);
		System.out.println("-----------------------------------");

	}
	

}
