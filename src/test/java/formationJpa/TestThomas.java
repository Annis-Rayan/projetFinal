package formationJpa;

import javax.persistence.Persistence;

import projetFinal.dao.DaoAnimal;
import projetFinal.dao.DaoAnimalFactory;
import projetFinal.entity.Animal;

public class TestThomas {

	public static void main(String[] args) {
		
		Persistence.createEntityManagerFactory("projetfinal");
		
		DaoAnimal daoAnimal=DaoAnimalFactory.getInstance();
		
		Animal animal = new Animal();
		
		animal.setNomCourant("Mesange charbonniere");
		daoAnimal.insert(animal);
		

		Animal animal1 = new Animal();
		
		animal1.setNomCourant("Pinson");
		daoAnimal.insert(animal1);

		Animal animal2 = new Animal();
		
		animal.setNomCourant("Rossignol philomele");
		daoAnimal.insert(animal2);
	}

}
