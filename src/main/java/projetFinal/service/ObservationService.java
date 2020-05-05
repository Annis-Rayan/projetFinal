package projetFinal.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projetFinal.entity.Localisation;
import projetFinal.entity.Observation;
import projetFinal.exception.NoObservationFoundException;
import projetFinal.exception.NolocalisationFoundException;
import projetFinal.repository.ObservationRepositery;



@Service
public class ObservationService {
	@Autowired
	private ObservationRepositery observationRepository;

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

	public Observation miseAjour(Observation observation) throws NoObservationFoundException {
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

			return observationEnBase;
		} else {
			throw new NoObservationFoundException();
		}
		

	}

	public Observation recherche(Integer id) {
		Optional<Observation> opt=observationRepository.findById(id);
		if(opt.isPresent()) {
			return opt.get();
		}
		throw new IllegalArgumentException();
	}
	
	public boolean suppression(Integer id){
		Optional<Observation> opt = observationRepository.findById(id);
		if (opt.isPresent()) {
			observationRepository.deleteById(id);
			return true;
		}
		
		return false;
	}

}
