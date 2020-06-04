package projetFinalBoot.restController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/login")
@CrossOrigin(origins = "*")
public class LoginRestController {
	
	
	@GetMapping("/{user}/{mdp}")
	public ResponseEntity<Boolean> login() {
		
		
		
		
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	

}
