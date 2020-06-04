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

import projetFinalBoot.entity.Observation;
import projetFinalBoot.entity.views.Views;
import projetFinalBoot.service.ObservationService;

@RestController
@RequestMapping("/rest/observation")
@CrossOrigin (origins = "*")
public class ObservationRestController {

	@Autowired
	ObservationService observationService;
	
	@JsonView(Views.Common.class)
	@GetMapping({ "", "/" })
	public ResponseEntity<List<Observation>> findAll() {
		
		List<Observation> list = observationService.findAll();
		return new ResponseEntity<List<Observation>>(list, HttpStatus.OK);
	}	

	@PostMapping({ "", "/" })
	public ResponseEntity<Void> addObservation(@Valid @RequestBody Observation observation, BindingResult br,
			UriComponentsBuilder uCB) {
		if (br.hasErrors()) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
		observationService.save(observation);

		URI uri = uCB.path("/rest/observation/{id}").buildAndExpand(observation.getId()).toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@JsonView(Views.Common.class)
	@GetMapping("/{id}")
	public ResponseEntity<Observation> findById(@PathVariable("id") Integer id) {
		Optional<Observation> opt = observationService.findById(id);
		if (opt.isPresent()) {
			return new ResponseEntity<Observation>(opt.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<Observation>(HttpStatus.NOT_FOUND);
		}
	}
	
	

	@JsonView(Views.ObservationWithAnimal.class)
	@GetMapping("/{id}/observation")
	public ResponseEntity<Observation> findByIdWithAnimal(@PathVariable("id") Integer id) {
		Optional<Observation> opt = observationService.findById(id);
		if (opt.isPresent()) {
			return new ResponseEntity<Observation>(opt.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
		Optional<Observation> opt = observationService.findById(id);
		if (opt.isPresent()) {
			observationService.deleteById(id);
			
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@Valid @RequestBody Observation observation, BindingResult br,
			@PathVariable("id") Integer id) throws Exception {
		
		if (br.hasErrors())
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
		if (observationService.update(observation)) 
			return new ResponseEntity<>(HttpStatus.OK);
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		 
	}
	
	
}
