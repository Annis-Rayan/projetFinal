package projetFinalBoot.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projetFinalBoot.entity.Signalement;
import projetFinalBoot.repository.SignalementRepository;

@Service
public abstract class SignalementService {
	
	@Autowired
	private SignalementRepository signalementRepository;
	
	public void ajout(Signalement signalement) {
		if(signalement.getDescription().isEmpty()) {
			signalement.setDescription("Description absente");
		}
		
		
		signalementRepository.save(signalement);
	}
	
	public Signalement miseAjour(Signalement signalement) throws Exception {
		Optional<Signalement> opt = signalementRepository.findById(signalement.getId());
		if(opt.isPresent()) {
			Signalement signalementEnBase = opt.get();
			if(signalement.getDescription()!=null) {
				signalementEnBase.setDescription(signalement.getDescription());
			}

			signalementEnBase.setAuteur(signalement.getAuteur());
			
			signalementRepository.save(signalement);
			return signalementEnBase;
		}else {
			
			throw new Exception();
		}
		
	}
	
	public Signalement recherche(Integer id) {
		Optional<Signalement> opt = signalementRepository.findById(id);
		if(opt.isPresent()) {
			return opt.get();
		}
		throw new IllegalArgumentException();
	}
	
	
	
}
