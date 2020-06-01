package projetFinalBoot.restController;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.annotation.JsonView;

import projetFinalBoot.entity.Utilisateur;
import projetFinalBoot.entity.views.Views;
import projetFinalBoot.service.UtilisateurService;

@RestController
@RequestMapping("/rest/users")
@CrossOrigin(origins = "*")
public class UtilisateurRestController {
	
	@Autowired
	private UtilisateurService utilisateurService;
	
	@JsonView(Views.Common.class)
	@GetMapping({ "", "/" })
	public ResponseEntity<List<Utilisateur>> findAll() {
		List<Utilisateur> list = utilisateurService.rechercheAll();  // TO DO: method
		return new ResponseEntity<List<Utilisateur>>(list, HttpStatus.OK);
	}
	
	@JsonView(Views.Common.class)
	@GetMapping("/{id}")
	public ResponseEntity<Utilisateur> findById(@PathVariable("id") Integer id) {
		Optional<Utilisateur> opt = utilisateurService.rechercheById(id); // Error to check with Raph
		if (opt.isPresent()) {
			return new ResponseEntity<Utilisateur>(opt.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	//FindAllwithObs
	
	@JsonView(Views.UtilisateurWithObservation.class)
	@GetMapping("/observation")
	public ResponseEntity<List<Utilisateur>> findAllWithObservation() {
		List<Utilisateur> list = utilisateurService.rechercheAll(); // TO DO
		return new ResponseEntity<List<Utilisateur>>(list, HttpStatus.OK);
	}
	
	
	//findByPseudo
	
	@JsonView(Views.Common.class)
	@GetMapping("/{pseudo}")
	public ResponseEntity<Utilisateur> findByPseudo(@PathVariable("pseudo") String pseudo) {
		Optional<Utilisateur> opt = utilisateurService.rechercheByPseudo(pseudo); // Error to check with Raph
		if (opt.isPresent()) {
			return new ResponseEntity<Utilisateur>(opt.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	//findbyIdwithobs
	
	@JsonView(Views.UtilisateurWithObservation.class)
	@GetMapping("/{id}/observation")
	public ResponseEntity<Utilisateur> findByIdWithObservation(@PathVariable("id") Integer id) {
		Optional<Utilisateur> opt = utilisateurService.rechercheById(id); 
		if (opt.isPresent()) {
			return new ResponseEntity<Utilisateur>(opt.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	//findbyPseudowithobs
	
	@JsonView(Views.UtilisateurWithObservation.class)
	@GetMapping("/{pseudo}/observation")
	public ResponseEntity<Utilisateur> findByPseudoWithObservation(@PathVariable("pseudo") String pseudo) {
		Optional<Utilisateur> opt = utilisateurService.rechercheByPseudo(pseudo); //error to check with Raph
		if (opt.isPresent()) {
			return new ResponseEntity<Utilisateur>(opt.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	@PostMapping({ "", "/" })
	public ResponseEntity<Void> addUtilisateur(@Valid @RequestBody Utilisateur utilisateur, BindingResult br,
			UriComponentsBuilder uCB) {
		if (br.hasErrors()) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
		utilisateurService.save(utilisateur);

		URI uri = uCB.path("/rest/users/{id}").buildAndExpand(utilisateur.getId()).toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
		Optional<Utilisateur> opt = utilisateurService.rechercheById(id); 
		if (opt.isPresent()) {
			utilisateurService.deleteById(id);
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}

	
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@Valid @RequestBody Utilisateur utilisateur, BindingResult br,
			@PathVariable("id") Integer id) {
		if (br.hasErrors()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Optional<Utilisateur> opt = utilisateurService.rechercheById(id);
		if (opt.isPresent()) {
			Utilisateur utilisateurEnBase = opt.get();
			utilisateurEnBase.setPseudo(utilisateur.getPseudo());
			utilisateurEnBase.setNom(utilisateur.getNom());
			utilisateurEnBase.setPrenom(utilisateur.getPrenom());
			utilisateurEnBase.setImageProfil(utilisateur.getImageProfil());
			if (utilisateur.getObservations() != null) {
				utilisateurEnBase.setObservations(utilisateur.getObservations());
			}
			utilisateurService.save(utilisateurEnBase);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
