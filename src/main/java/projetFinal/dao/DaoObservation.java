package projetFinal.dao;

import java.util.List;
import java.util.Optional;
import projetFinal.entity.Observation;


public interface DaoObservation extends DaoGeneric <Observation, Integer> {
	
	public List<Observation> findByAnimal(String animal);

	public List<Observation> findByUtilisateur(String utilisateur);
	
	public List<Observation> findByLocalisation(String localisation);

	//public List<Observation> findAllWithStagiaires();

	public Optional<Observation> findByKey(Integer key);

}
