package projetFinalBoot.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import projetFinalBoot.entity.Animal;
import projetFinalBoot.entity.Localisation;
import projetFinalBoot.entity.Observation;
import projetFinalBoot.entity.Utilisateur;
import projetFinalBoot.repository.LocalisationRepository;
import projetFinalBoot.repository.ObservationRepository;
import projetFinalBoot.repository.UtilisateurRepository;

@Service
public class ObservationService {
	@Autowired
	private ObservationRepository observationRepository;
	
	@Autowired
	private LocalisationRepository localisationRepository;
	
	@Autowired
	private UtilisateurRepository utilisateurRepository;
	
	@Autowired
	AnimalService as;


	public boolean save(Observation observation) {
		if (observation.getDateObservation()==null) {
			return false;
		}
		if (observation.getNombre()<1 ) {
			return false;		
			}
		if (observation.getDescription().isEmpty()) {
			observation.setDescription("non defini");
		}
		
		if(observation.getLocalisation().getId()==null) {
			localisationRepository.save(observation.getLocalisation());
		}
		
		observationRepository.save(observation);
		return true;
	}

	public boolean update(Observation observation) throws Exception {
		Optional<Observation> opt = observationRepository.findById(observation.getId());
		if (opt.isPresent()) {
			Observation observationEnBase = opt.get();
			if (observation.getDateObservation() != null) {
				observationEnBase.setDateObservation(observation.getDateObservation());
			}
			if (observation.getNombre() != null) {
				observationEnBase.setNombre(observation.getNombre());
			}
			if (observation.getDescription() != null) {
				observationEnBase.setDescription(observation.getDescription());
			}
			if (observation.getLocalisation() != null) {
				observationEnBase.setLocalisation(observation.getLocalisation());
			}
			if (observation.getUtilisateur() != null) {
				observationEnBase.setUtilisateur(observation.getUtilisateur());
			}
			if (observation.getAnimal() != null) {
				observationEnBase.setAnimal(observation.getAnimal());
			}
			
			if(observation.getLocalisation().getId()==null) {
				localisationRepository.save(observation.getLocalisation());
			}
			
			observationRepository.save(observation);
			
			
			observationRepository.save(observationEnBase);
			return true;
			
		} 
			return false;
		
	}

	public Optional<Observation> findById(Integer id) {
		return observationRepository.findById(id);
		
	}
	
	public List<Observation> findByAnimal(String nom) {
		Animal animal = as.findByNom(nom).get(0);
		
		Observation obs=new Observation();
		obs.setAnimal(animal);
		Example<Observation> example= Example.of(obs);
		return observationRepository.findAll(example);
		
	}
	
	public List<Observation> findByUser(String nom) {
		Utilisateur user = utilisateurRepository.findByPseudo(nom).get();
		
		Observation obs=new Observation();
		obs.setUtilisateur(user);;
		Example<Observation> example= Example.of(obs);
	    return observationRepository.findAll(example);
		
	}
	
	
	
	
	public boolean delete(Integer id){
		Optional<Observation> opt = observationRepository.findById(id);
		if (opt.isPresent()) {
			observationRepository.deleteById(id);
			return true;
		}
		return false;
	}
	
	public void deleteAnimalDoublon(Animal remplacement, Animal doublon) throws Exception {
		
		//recupere tout les doublons
		Observation obs=new Observation();
		obs.setAnimal(doublon);
		Example<Observation> example= Example.of(obs);
	    List<Observation> listeObservation = observationRepository.findAll(example);
		
		
	    //update les doublons avec le nom
	    for (Observation observation : listeObservation) {
			observation.setAnimal(remplacement);
			update(observation);
		}
		
		//supprime l'animal en doublon
		as.deleteById(doublon.getId());
	}
	
	//TODO
public void deleteLocalisationParRegion(String remplacement, String doublon) {
		
		//recupere tout les doublons
		Observation obs=new Observation();
		obs.setLocalisation(new Localisation(doublon,null));
		Example<Observation> example= Example.of(obs);
	    List<Observation> listeObservation = observationRepository.findAll(example);
		
		
	    //cherche de toutes les observations qui contiennent le doublon
	    for (Observation observation : listeObservation) {
	    	
	    	Localisation l =new Localisation(remplacement,observation.getLocalisation().getLocalite());
	    	Example<Localisation> ex=Example.of(l);
	    	List<Localisation> listLocalisation = localisationRepository.findAll(ex);
	    		
	    		// si le remplacement et la localit�e existent d�ja, supprimer le doublon et relier l'observation
	    		for (Localisation localisation : listLocalisation) {
	    			Localisation loc =new Localisation(doublon,observation.getLocalisation().getLocalite());
	    	    	Example<Localisation> asuppr=Example.of(loc);
	    	    	List<Localisation> localisationasuppr = localisationRepository.findAll(asuppr);
	    	    	
	    	    	
				}
	    	//observation.getLocalisation().setRegion(remplacement);
	    	
		}
	    	//si present dans la base :suppression
	    	
	    
	    	//si non present dans la base :maj
	    
	    
	   // for (Observation observation : listeObservation) {
		//	observation.setAnimal(remplacement);
		//	miseAjour(observation);
		//}
		
		//supprime l'animal en doublon
		//AnimalService as= new AnimalService();
		//as.suppression(doublon.getId());
	}
public void deleteLocalisationParLocalite(String remplacement, String doublon) {
	
}

public List<Observation> findAll() {
	return observationRepository.findAll();
}



public void deleteById(Integer id) {
	observationRepository.delete(observationRepository.getOne(id));
	
}




}
