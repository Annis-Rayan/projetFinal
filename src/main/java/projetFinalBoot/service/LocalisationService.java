package projetFinalBoot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
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
		
		if (localisation.getPays()==null || localisation.getPays().isEmpty()) {
			localisation.setPays("non defini");
		}
		if (localisation.getRegion()==null || localisation.getRegion().isEmpty()) {
			localisation.setRegion("non defini");
		}
		if (localisation.getLocalite()==null || localisation.getLocalite().isEmpty()) {
			localisation.setLocalite("non defini");
		}
		
		localisationRepository.save(localisation);
	}

	
	
	public boolean update(Localisation localisation) throws Exception {
		Optional<Localisation> opt = localisationRepository.findById(localisation.getId());
		
		if (opt.isPresent()) {
			Localisation localisationEnBase = opt.get();
			
			if (localisation.getPays() != null) {
				localisationEnBase.setPays(localisation.getPays());
			}
			if (localisation.getRegion() != null) {
				localisationEnBase.setRegion(localisation.getRegion());
			}
			if (localisation.getLocalite() != null) {
				localisationEnBase.setLocalite(localisation.getLocalite());
			}
		
			
			localisationRepository.save(localisationEnBase);
			return true;

		} else {
			return false;
		}
	}
	

	public Optional<Localisation> findById (Integer id)  {
		Optional<Localisation> opt = localisationRepository.findById(id);
		if (opt.isPresent()) {
			return opt;
		
			} 
		else {
			throw new IllegalArgumentException();
		}		
				
	} 
	
	public boolean deleteById(Integer id) {
		
		Optional<Localisation> opt = localisationRepository.findById(id);
		if (opt.isPresent()) {
			
			Observation obs  = new Observation();
			obs.setLocalisation(opt.get());
			Example<Observation> example = Example.of(obs);
			List<Observation> listeobs =observationRepository.findAll(example);
			for (Observation observation : listeobs) {
				observationRepository.delete(observation);
			}
			
			
	
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

	public List<Localisation> findAll() {
		return localisationRepository.findAll();
	}

	


	public List<Localisation> findByPays(String pays) {
		
		Localisation loc = new Localisation();
		loc.setPays(pays);
		Example<Localisation> example = Example.of(loc);
		return localisationRepository.findAll(example);
	}
	public List<Localisation> findByRegion(String region) {
		

		Localisation loc = new Localisation();
		loc.setRegion(region);
		Example<Localisation> example = Example.of(loc);
		return localisationRepository.findAll(example);
	}
	
	public List<Localisation> findLocalite(String localite) {
		
		Localisation loc = new Localisation();
		loc.setLocalite(localite);
		Example<Localisation> example = Example.of(loc);
		return localisationRepository.findAll(example);
	}
	
	public List<Localisation> findByRegionContains(String nom)
	{
		Localisation localisation = new Localisation();
		localisation.setRegion(nom);
		ExampleMatcher matcher = ExampleMatcher.matching()
				.withIgnoreCase("name")
				.withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
		Example<Localisation> example = Example.of(localisation, matcher);
		return localisationRepository.findAll(example);	
	}
	
	public List<Localisation> findByLocaliteeContains(String nom)
	{
		Localisation localisation = new Localisation();
		localisation.setLocalite(nom);
		ExampleMatcher matcher = ExampleMatcher.matching()
				.withIgnoreCase("name")
				.withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
		Example<Localisation> example = Example.of(localisation, matcher);
		return localisationRepository.findAll(example);	
	}
}
