package projetFinal.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projetFinal.entity.Animal;
import projetFinal.exception.NoAnimalFoundException;
import projetFinal.repository.AnimalRepository;



@Service
public class AnimalService {

	@Autowired
	private AnimalRepository animalRepository;

	public void ajout(Animal animal) {
		
		if (animal.getNomScientifique().isEmpty()) {
			animal.setNomScientifique("non defini");
		}
		if (animal.getDescription().isEmpty()) {
			animal.setDescription("non defini");
		}
		if (animal.getEmplacementImage().isEmpty()) {
			animal.setEmplacementImage("non defini");
		}
		
		animalRepository.save(animal);
	}

	public Animal miseAjour(Animal animal) throws NoAnimalFoundException {
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
			throw new NoAnimalFoundException();
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
