package formationJpa;

import javax.persistence.Persistence;

import projetFinal.dao.DaoAnimal;
import projetFinal.dao.DaoAnimalFactory;
import projetFinal.entity.Animal;

public class TestThomas {

	public static void main(String[] args) {
		
		Persistence.createEntityManagerFactory("projetsopra");
		
		DaoAnimal daoAnimal=DaoAnimalFactory.getInstance();
		
		Animal animal = new Animal();
	}

}
