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

import projetFinalBoot.entity.Animal;
import projetFinalBoot.entity.views.Views;
import projetFinalBoot.service.AnimalService;

@RestController
@RequestMapping("/rest/animal")
@CrossOrigin(origins = "*")
public class AnimalRestController {
	
	@Autowired
	AnimalService animalService;
	
	@JsonView(Views.Common.class)
	@GetMapping({ "", "/" })
	public ResponseEntity<List<Animal>> findAll() {
		List<Animal> list = animalService.findAll();
		return new ResponseEntity<List<Animal>>(list, HttpStatus.OK);
	}

	@JsonView(Views.AnimalwithObservation.class)
	@GetMapping("/observation")
	public ResponseEntity<List<Animal>> findAllWithobservation() {
		List<Animal> list = animalService.findAll();
		return new ResponseEntity<List<Animal>>(list, HttpStatus.OK);
	}

	@PostMapping({ "", "/" })
	public ResponseEntity<Void> addAnimal(@Valid @RequestBody Animal animal, BindingResult br,
			UriComponentsBuilder uCB) {
		if (br.hasErrors()) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
		animalService.save(animal);

		URI uri = uCB.path("/rest/animal/{id}").buildAndExpand(animal.getId()).toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@JsonView(Views.Common.class)
	@GetMapping("/{id}")
	public ResponseEntity<Animal> findById(@PathVariable("id") Integer id) {
		Optional<Animal> opt = animalService.findById(id);
		if (opt.isPresent()) {
			return new ResponseEntity<Animal>(opt.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@JsonView(Views.AnimalwithObservation.class)
	@GetMapping("/{id}/observation")
	public ResponseEntity<Animal> findByIdWithObservation(@PathVariable("id") Integer id) {
		Optional<Animal> opt = animalService.findById(id);
		if (opt.isPresent()) {
			return new ResponseEntity<Animal>(opt.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
		Optional<Animal> opt = animalService.findById(id);
		if (opt.isPresent()) {
			animalService.deleteById(id);
			
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@Valid @RequestBody Animal animal, BindingResult br,
			@PathVariable("id") Integer id) throws Exception {
		
		if (br.hasErrors())
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
		if (animalService.update(animal)) 
			return new ResponseEntity<>(HttpStatus.OK);
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		 
	}		

}
