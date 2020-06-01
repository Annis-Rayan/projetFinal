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
import projetFinalBoot.repository.LocalisationRepository;
import projetFinalBoot.repository.ObservationRepository;

@Service
public class ObservationService {
	@Autowired
	private ObservationRepository observationRepository;
	
	@Autowired
	private LocalisationRepository localisationRepository;
	
	@Autowired
	AnimalService as;


	public boolean ajout(Observation observation) {
		if (observation.getDateObservation()==null) {
			return false;
		}
		if (observation.getNombre()<1 ) {
			return false;		
			}
		if (observation.getDescription().isEmpty()) {
			observation.setDescription("non defini");
		}
		observationRepository.save(observation);
		return true;
	}

	public boolean miseAjour(Observation observation) throws Exception {
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
			observationRepository.save(observationEnBase);
			return true;
			
		} 
			return false;
		
	}

	public Observation recherche(Integer id) {
		Optional<Observation> opt=observationRepository.findById(id);
		if(opt.isPresent()) {
			return opt.get();
		}
		throw new IllegalArgumentException();
	}
	
	public List<Observation> recherche(Date dateObservation) {
		Observation obs = new Observation();
		obs.setDateObservation(dateObservation);
		Example<Observation> example = Example.of(obs);
		return observationRepository.findAll(example);
		
	}
	
	
	public boolean suppression(Integer id){
		Optional<Observation> opt = observationRepository.findById(id);
		if (opt.isPresent()) {
			observationRepository.deleteById(id);
			return true;
		}
		return false;
	}
	
	public void suppressionAnimal(Animal remplacement, Animal doublon) throws Exception {
		
		//recupere tout les doublons
		Observation obs=new Observation();
		obs.setAnimal(doublon);
		Example<Observation> example= Example.of(obs);
	    List<Observation> listeObservation = observationRepository.findAll(example);
		
		
	    //update les doublons avec le nom
	    for (Observation observation : listeObservation) {
			observation.setAnimal(remplacement);
			miseAjour(observation);
		}
		
		//supprime l'animal en doublon
		as.suppression(doublon.getId());
	}
	
	//TODO
public void suppressionLocalisationParRegion(String remplacement, String doublon) {
		
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
public void suppressionLocalisationParLocalite(String remplacement, String doublon) {
	
}

public List<Observation> findAll() {
	// TODO Auto-generated method stub
	return null;
}

public void save(@Valid Observation observation) {
	// TODO Auto-generated method stub
	
}

public Optional<Observation> findById(Integer id) {
	// TODO Auto-generated method stub
	return null;
}

public void deleteById(Integer id) {
	// TODO Auto-generated method stub
	
}
}
