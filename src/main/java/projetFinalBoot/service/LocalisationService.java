package projetFinalBoot.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import projetFinalBoot.entity.Localisation;
import projetFinalBoot.entity.Observation;
import projetFinalBoot.repository.LocalisationRepository;
import projetFinalBoot.repository.ObservationRepository;

@Service
public class LocalisationService {
	
	@Autowired
	private LocalisationRepository localisationRepository;
	
	@Autowired
	private ObservationRepository observationRepository;
	
	public void save(Localisation localisation) {
		if (localisation.getLocalite().isEmpty()) {
			localisation.setLocalite("non defini");
		}
		localisationRepository.save(localisation);
	}
	
	public Localisation update(Localisation localisation) throws Exception {
		Optional<Localisation> opt = localisationRepository.findById(localisation.getID());
		if (opt.isPresent()) {
			Localisation locenbase = opt.get();
			if (localisation.getPays() != null) {
				locenbase.setPays(localisation.getPays());
			}
			if (localisation.getRegion() != null) {
				locenbase.setRegion(localisation.getRegion());
			}
			
			
			locenbase.setLocalite(localisation.getLocalite());
			localisationRepository.save(locenbase);
			return locenbase;
		} else {
			throw new Exception();
		}
		 

	}
	
	public Optional<Localisation> findById(Integer id) {
		return localisationRepository.findById(id);

	}
	
	public boolean delete(Integer id){
		Optional<Localisation> opt = localisationRepository.findById(id);
		if (opt.isPresent()) {
			localisationRepository.deleteById(id);
			return true;
		}
		
		return false;
	}
		
	public List<Localisation> findByRegionAndLocalite(String region,String localite) {
		
		Localisation loc=new Localisation();
		loc.setLocalite(localite);
		loc.setRegion(region);
		
		return localisationRepository.findAll(Example.of(loc));
	}
	
	//TODO enlever id=1
	public List<Localisation> findAll() {
		return localisationRepository.findAll();
	}

	
	
	public void deleteById(Integer id) {
		
		Optional<Localisation> opt = localisationRepository.findById(id);
		//si il n'y a pas d'id alors erreur
		if(!opt.isPresent()) {
			throw new IllegalArgumentException();
		}
		
		//récuperation des observations faites par l'utilisateur
		Observation obs=new Observation();
		obs.setLocalisation(opt.get());
		Example<Observation> example= Example.of(obs);
		List<Observation> listeObservation = observationRepository.findAll(example);
		
		Localisation l1 = localisationRepository.findById(1).get();
		 for (Observation observation : listeObservation) {
				observation.setLocalisation(l1);
				observationRepository.save(observation);
			}
		 
		 localisationRepository.delete(opt.get());
		
	}
	
	
}