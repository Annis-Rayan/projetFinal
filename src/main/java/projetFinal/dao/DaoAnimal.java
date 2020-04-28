package projetFinal.dao;


import java.util.Optional;

import projetFinal.entity.Animal;


public interface DaoAnimal extends DaoGeneric<Animal, Integer>{

	public Optional<Animal> findByNomCourant(String nomCourant);
	public Optional<Animal> findByNomScientifique(String nomScientifique);
	
	
}
