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

import projetFinalBoot.entity.Localisation;
import projetFinalBoot.entity.views.Views;
import projetFinalBoot.service.LocalisationService;



@RestController
@RequestMapping("/rest/localisation")
@CrossOrigin(origins = "*")
public class LocalisationRestController {

	@Autowired
	private LocalisationService localisationService;

	@JsonView(Views.Common.class)
	@GetMapping({ "", "/" })
	public ResponseEntity<List<Localisation>> findAll() {
		List<Localisation> list = localisationService.findAll();
		return new ResponseEntity<List<Localisation>>(list, HttpStatus.OK);
	}

	@JsonView(Views.LocalisationWithObservation.class)
	@GetMapping("/observation")
	public ResponseEntity<List<Localisation>> findAllWithObservation() {
		List<Localisation> list = localisationService.findAll();
		return new ResponseEntity<List<Localisation>>(list, HttpStatus.OK);
	}

	@PostMapping({ "", "/" })
	public ResponseEntity<Void> addLocalisation(@Valid @RequestBody Localisation localisation, BindingResult br,
			UriComponentsBuilder uCB) {
		if (br.hasErrors()) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
		localisationService.save(localisation);

		URI uri = uCB.path("/rest/localisation/{id}").buildAndExpand(localisation.getID()).toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@JsonView(Views.Common.class)
	@GetMapping("/{id}")
	public ResponseEntity<Localisation> findById(@PathVariable("id") Integer id) {
		Optional<Localisation> opt = localisationService.findById(id);
		if (opt.isPresent()) {
			return new ResponseEntity<Localisation>(opt.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@JsonView(Views.LocalisationWithObservation.class)
	@GetMapping("/{id}/observation")
	public ResponseEntity<Localisation> findByIdWithStagiaire(@PathVariable("id") Integer id) {
		Optional<Localisation> opt = localisationService.findById(id);
		if (opt.isPresent()) {
			return new ResponseEntity<Localisation>(opt.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
		Optional<Localisation> opt = localisationService.findById(id);
		if (opt.isPresent()) {
			localisationService.deleteById(id);
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@Valid @RequestBody Localisation localisation, BindingResult br,
			@PathVariable("id") Integer id) {
		if (br.hasErrors()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Optional<Localisation> opt = localisationService.findById(id);
		if (opt.isPresent()) {
			Localisation localisationEnBase = opt.get();
			localisationEnBase.setPays(localisation.getPays());
			localisationEnBase.setRegion(localisation.getRegion());
			localisationEnBase.setLocalite(localisation.getLocalite());
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

}
