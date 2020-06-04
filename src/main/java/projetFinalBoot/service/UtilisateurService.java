package projetFinalBoot.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import projetFinalBoot.entity.Observation;
import projetFinalBoot.entity.Utilisateur;
import projetFinalBoot.repository.ObservationRepository;
import projetFinalBoot.repository.UtilisateurRepository;

@Service
public class UtilisateurService {
	@Autowired
	private UtilisateurRepository utilisateurRepository;
	
	@Autowired
	private ObservationRepository observationRepository;
	
	
	public Optional<Utilisateur> findById(Integer id) {
		Optional<Utilisateur> opt = utilisateurRepository.findById(id);
		if(opt.isPresent()) {
			return opt;
		}
		throw new IllegalArgumentException();
	}
	
	public Optional<Utilisateur> findByPseudo(String pseudo) {
		
		Utilisateur u = new Utilisateur();
		u.setPseudo(pseudo);
		Example<Utilisateur> example = Example.of(u);
		
		Optional<Utilisateur> opt = utilisateurRepository.findOne(example);
		if(opt.isPresent()) {
			return opt;
		}
		throw new IllegalArgumentException();
	}
	

	public List<Utilisateur> findAll() {
		
		List<Utilisateur> l =utilisateurRepository.findAll();
		Utilisateur u =utilisateurRepository.findById(1).get();
		l.remove(u);
		
		return l;
	}
	
	public void save( Utilisateur utilisateur) {
		
		utilisateurRepository.save(utilisateur);
	}

	public void deleteById(Integer id) {
		
		Optional<Utilisateur> opt=utilisateurRepository.findById(id);
		//si il n'y a pas d'id alors erreur
		if(!opt.isPresent()) {
			throw new IllegalArgumentException();
		}
		
		//récuperation des observations faites par l'utilisateur
		Observation obs=new Observation();
		obs.setUtilisateur(opt.get());
		Example<Observation> example= Example.of(obs);
	    List<Observation> listeObservation = observationRepository.findAll(example);
		
	    //remplacement dans ces observations par l'utilisateur avec l'id 1
	    Utilisateur u1 = utilisateurRepository.findById(1).get();
	    for (Observation observation : listeObservation) {
			observation.setUtilisateur(u1);
			observationRepository.save(observation);
		}
	    
	    //TODO signalement 
	    
	    utilisateurRepository.delete(opt.get());
	    
	}
	
}
