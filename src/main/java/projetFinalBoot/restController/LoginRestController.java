package projetFinalBoot.restController;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.crypto.password.PasswordEncoder;

import projetFinalBoot.entity.Login;
import projetFinalBoot.entity.Role;
import projetFinalBoot.repository.LoginRepository;

@RestController
@RequestMapping("/rest/login")
@CrossOrigin(origins = "*")
public class LoginRestController {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private LoginRepository loginRepository;
	
	@PostMapping({ "", "/" })
	public ResponseEntity<Login> login(@Valid @RequestBody Login login,BindingResult br) {
		
		if(br.hasErrors()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		Optional<Login> opt = loginRepository.findByName(login.getLogin());
		
		if(opt.isPresent() )
			if( passwordEncoder.matches(login.getPassword(),opt.get().getPassword()))
				return new ResponseEntity<Login>(opt.get(),HttpStatus.OK);
		
		return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
	}
	
	
}
