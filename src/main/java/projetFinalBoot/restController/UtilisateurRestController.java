package projetFinalBoot.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import projetFinalBoot.entity.Utilisateur;
import projetFinalBoot.entity.views.Views;
import projetFinalBoot.repository.UtilisateurRepository;

@RestController
@RequestMapping("/rest/users")
@CrossOrigin(origins = "*")
public class UtilisateurRestController {
	
	@Autowired
	private UtilisateurRepository utilisateurRepository;
	
	@JsonView(Views.Common.class)
	@GetMapping({ "", "/" })
	public ResponseEntity<List<Utilisateur>> findAll() {
		List<Utilisateur> list = utilisateurRepository.findAll();
		return new ResponseEntity<List<Utilisateur>>(list, HttpStatus.OK);
	}

}
