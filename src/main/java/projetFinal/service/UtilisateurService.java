package projetFinal.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projetFinal.entity.Utilisateur;
import projetFinal.repository.UtilisateurRepository;

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
	
	public Utilisateur miseAjour(Utilisateur utilisateur) {
		Optional<Utilisateur> opt = utilisateurRepository.findById(utilisateur.getId());
		if(opt.isPresent()) {
			Utilisateur utilisateurEnBase = opt.get();
			if(utilisateur.getPseudo()!=null) {
				utilisateurEnBase.setPseudo(utilisateur.getPseudo());
			}

			utilisateurEnBase.setNom(utilisateur.getNom());
			utilisateurEnBase.setPrenom(utilisateur.getPrenom());
			utilisateurRepository.save(utilisateur);
			return utilisateurEnBase;
		}else {
			
			return null;
		}
		
	}
	
	public Utilisateur recherche(Integer id) {
		Optional<Utilisateur> opt = utilisateurRepository.findById(id);
		if(opt.isPresent()) {
			return opt.get();
		}
		throw new IllegalArgumentException();
	}
	
	
	
	
}
