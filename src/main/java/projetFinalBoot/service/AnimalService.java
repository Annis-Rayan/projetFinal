package projetFinalBoot.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projetFinalBoot.entity.Animal;
import projetFinalBoot.repository.AnimalRepository;



@Service
public class AnimalService {

	@Autowired
	private AnimalRepository animalRepository;

	public void ajout(Animal animal) {
		
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

	public Animal miseAjour(Animal animal) throws Exception {
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
			return animal;
			
		} else {
			throw new Exception();
		}
		
		// throw new NoAnimalFoundException()
	}
	
	public Animal recherche (Integer id)  {
		
		Optional<Animal> opt = animalRepository.findById(id);
		if (opt.isPresent()) {
			return opt.get();
		
			} 
		else {
			throw new IllegalArgumentException();
		}		
				
	} 
	
	public boolean suppression(Integer id) {
		
		
		Optional<Animal> opt = animalRepository.findById(id);
		if (opt.isPresent()) {
			animalRepository.deleteById(id);
			return true;

		}
		return false;
	}
}
