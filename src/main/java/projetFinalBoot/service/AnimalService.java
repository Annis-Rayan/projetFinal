package projetFinalBoot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import projetFinalBoot.entity.Animal;
import projetFinalBoot.entity.Observation;
import projetFinalBoot.entity.Ordre;
import projetFinalBoot.repository.AnimalRepository;
import projetFinalBoot.repository.ObservationRepository;



@Service
public class AnimalService {

	@Autowired
	private AnimalRepository animalRepository;
	
	@Autowired
	private ObservationRepository observationRepository;

	public void save(Animal animal) {
		
		if (animal.getNomScientifique()==null || animal.getNomScientifique().isEmpty()) {
			animal.setNomScientifique("non defini");
		}
		if (animal.getDescription()==null || animal.getDescription().isEmpty()) {
			animal.setDescription("non defini");
		}
		if (animal.getEmplacementImage()==null || animal.getEmplacementImage().isEmpty()) {
			animal.setEmplacementImage("non defini");
		}
		
		animalRepository.save(animal);
	}

	public boolean update(Animal animal) throws Exception {
		Optional<Animal> opt = animalRepository.findById(animal.getId());
		//Optional<Animal> opt2 = animalRepository.findByNomCourant(animal.getNomCourant());
		if (opt.isPresent()) {
			Animal animalEnBase = opt.get();
			if (animal.getNomCourant() != null) {
				animalEnBase.setNomCourant(animal.getNomCourant());
			}
			if (animal.getNomScientifique() != null) {
				animalEnBase.setNomScientifique(animal.getNomScientifique());
			}
			if (animal.getDescription() != null) {
				animalEnBase.setDescription(animal.getDescription());
			}
			if (animal.getEmplacementImage() != null) {
				animalEnBase.setEmplacementImage(animal.getEmplacementImage());
			}
			if (animal.getOrdre() != null) {
				animalEnBase.setOrdre(animal.getOrdre());
			}
			if (animal.getObservations() != null) {
				animalEnBase.setObservations(animal.getObservations());
			}
			
			animalRepository.save(animalEnBase);
			return true;
			
		} else {
			return false;
		}
	}
	
	public Optional<Animal> findById (Integer id)  {
		Optional<Animal> opt = animalRepository.findById(id);
		if (opt.isPresent()) {
			return opt;
		
			} 
		else {
			throw new IllegalArgumentException();
		}		
				
	} 
	
	public boolean deleteById(Integer id) {
		
		Optional<Animal> opt = animalRepository.findById(id);
		if (opt.isPresent()) {
			
			Observation obs  = new Observation();
			obs.setAnimal(opt.get());
			Example<Observation> example = Example.of(obs);
			List<Observation> listeobs =observationRepository.findAll(example);
			for (Observation observation : listeobs) {
				observationRepository.delete(observation);
			}
			
			
			
			animalRepository.deleteById(id);
			return true;

		}
		return false;
	}

	public List<Animal> findAll() {
		return animalRepository.findAll();
	}

	

	public List<Animal> findByNom(String nom) {
		
		Animal ani = new Animal();
		ani.setNomCourant(nom);
		Example<Animal> example = Example.of(ani);
		return animalRepository.findAll(example);
	}
	
	public List<Animal> findByNomContains(String nom)
	{
		Animal animal = new Animal();
		animal.setNomCourant(nom);
		ExampleMatcher matcher = ExampleMatcher.matching()
				.withIgnoreCase("name")
				.withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
		Example<Animal> example = Example.of(animal, matcher);
		return animalRepository.findAll(example);
	}
	
	public List<Animal> findByOrdre(Ordre o) {
		
		Animal ani = new Animal();
		ani.setOrdre(o);
		Example<Animal> example = Example.of(ani);
		return animalRepository.findAll(example);
	}
	
public List<Animal> findByNomScientifique(String nom) {
		
	Animal animal = new Animal();
	animal.setNomScientifique(nom);
	ExampleMatcher matcher = ExampleMatcher.matching()
			.withIgnoreCase("name")
			.withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
	Example<Animal> example = Example.of(animal, matcher);
	return animalRepository.findAll(example);	
	}
}
