package formationJpa;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import projetFinal.dao.DaoObservation;
import projetFinal.dao.DaoObservationFactory;
import projetFinal.entity.Observation;

public class TestJonathan {
	public static void main(String[] args) {
		Observation obs = new Observation();
		
		System.out.println("-----------------------------------");
		DaoObservation daoObservation=DaoObservationFactory.getInstance();
		System.out.println("-----------------------------------");
		

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			obs.setDateObservation(sdf.parse("10/02/2019"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		obs.setNombre(2);	
		obs.setDescription("description");
		//obs.setId(1);
		System.out.println("-----------------------------------");

		daoObservation.insert(obs);
		System.out.println("-----------------------------------");

	}
	

}
