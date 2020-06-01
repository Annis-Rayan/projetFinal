package projetFinalBoot.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projetFinalBoot.entity.Utilisateur;
import projetFinalBoot.repository.UtilisateurRepository;

@Service
public class UtilisateurService {
	@Autowired
	private UtilisateurRepository utilisateurRepository;
	
	public void ajout(Utilisateur utilisateur) {
		if(utilisateur.getPseudo().isEmpty()) {
			utilisateur.setPseudo("Pseudo non defini");
		}
		
		utilisateurRepository.save(utilisateur);
	}
	
	public Utilisateur miseAjour(Utilisateur utilisateur) throws Exception {
		Optional<Utilisateur> opt = utilisateurRepository.findById(utilisateur.getId());
		if(opt.isPresent()) {
			Utilisateur utilisateurEnBase = opt.get();
			if(utilisateur.getPseudo()!=null) {
				utilisateurEnBase.setPseudo(utilisateur.getPseudo());
			}

			utilisateurEnBase.setNom(utilisateur.getNom());
			utilisateurEnBase.setPrenom(utilisateur.getPrenom());
			utilisateurEnBase.setImageProfil(utilisateur.getImageProfil());
			utilisateurRepository.save(utilisateur);
			return utilisateurEnBase;
		}else {
			
			throw new Exception();
		}
		
	}
	
	public Utilisateur rechercheById(Integer id) {
		Optional<Utilisateur> opt = utilisateurRepository.findById(id);
		if(opt.isPresent()) {
			return opt.get();
		}
		throw new IllegalArgumentException();
	}
	
	public Utilisateur rechercheByPseudo(String pseudo) {
		Optional<Utilisateur> opt = utilisateurRepository.findByPseudo(pseudo);
		if(opt.isPresent()) {
			return opt.get();
		}
		throw new IllegalArgumentException();
	}
	
	public Utilisateur rechercheByPseudoWithObservations(String pseudo) {
		Optional<Utilisateur> opt = utilisateurRepository.findByPseudoWithObservations(pseudo);
		if(opt.isPresent()) {
			return opt.get();
		}
		throw new IllegalArgumentException();
	}
	
	public Utilisateur rechercheByIdWithObservations(Integer id) {
		Optional<Utilisateur> opt = utilisateurRepository.findByIdWithObservations(id);
		if(opt.isPresent()) {
			return opt.get();
		}
		throw new IllegalArgumentException();
	}

	
	public List<Utilisateur> rechercheAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public Utilisateur save(@Valid Utilisateur utilisateur) {
		
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}
	
}
