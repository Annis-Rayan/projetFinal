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
	private LocalisationRepository locrep;
	
	@Autowired
	private ObservationRepository observationRepository;
	
	public void ajout(Localisation localisation) {
		if (localisation.getLocalite().isEmpty()) {
			localisation.setLocalite("non defini");
		}
		locrep.save(localisation);
	}
	
	public Localisation miseAjour(Localisation localisation) throws Exception {
		Optional<Localisation> opt = locrep.findById(localisation.getID());
		if (opt.isPresent()) {
			Localisation locenbase = opt.get();
			if (localisation.getPays() != null) {
				locenbase.setPays(localisation.getPays());
			}
			if (localisation.getRegion() != null) {
				locenbase.setRegion(localisation.getRegion());
			}
			
			
			locenbase.setLocalite(localisation.getLocalite());
			locrep.save(locenbase);
			return locenbase;
		} else {
			throw new Exception();
		}
		 

	}
	
	public Localisation recherche(Integer id) {
		Optional<Localisation> opt=locrep.findById(id);
		if(opt.isPresent()) {
			return opt.get();
		}
		throw new IllegalArgumentException();
	}
	
	public boolean suppression(Integer id){
		Optional<Localisation> opt = locrep.findById(id);
		if (opt.isPresent()) {
			locrep.deleteById(id);
			return true;
		}
		
		return false;
	}
		
	public List<Localisation> findByRegionAndLocalite(String region,String localite) {
		
		Localisation loc=new Localisation();
		loc.setLocalite(localite);
		loc.setRegion(region);
		
		return locrep.findAll(Example.of(loc));
	}

	public List<Localisation> findAll() {
		return locrep.findAll();
	}

	public void save(@Valid Localisation localisation) {
		locrep.save(localisation);
		
	}

	public Optional<Localisation> findById(Integer id) {
		Optional<Localisation> opt = locrep.findById(id);
		return opt;
	}

	public void deleteById(Integer id) {
		
		Optional<Localisation> opt = locrep.findById(id);
		//si il n'y a pas d'id alors erreur
		if(!opt.isPresent()) {
			throw new IllegalArgumentException();
		}
		
		//récuperation des observations faites par l'utilisateur
		Observation obs=new Observation();
		obs.setLocalisation(opt.get());
		Example<Observation> example= Example.of(obs);
		List<Observation> listeObservation = observationRepository.findAll(example);
		
		Localisation l1 = locrep.findById(1).get();
		 for (Observation observation : listeObservation) {
				observation.setLocalisation(l1);
				observationRepository.save(observation);
			}
		 
		 locrep.delete(opt.get());
		
	}
	
	
}