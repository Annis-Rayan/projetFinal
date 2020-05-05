package projetFinal.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projetFinal.entity.Localisation;
import projetFinal.exception.NolocalisationFoundException;
import projetFinal.repository.LocalisationRepository;

@Service
public class LocalisationService {
	
	@Autowired
	private LocalisationRepository locrep;
	
	public void ajout(Localisation localisation) {
		if (localisation.getLocalite().isEmpty()) {
			localisation.setLocalite("non defini");
		}
		locrep.save(localisation);
	}
	
	public Localisation miseAjour(Localisation localisation) throws NolocalisationFoundException {
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
			throw new NolocalisationFoundException();
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
	
}