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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.crypto.password.PasswordEncoder;

import projetFinalBoot.entity.Login;
import projetFinalBoot.repository.LoginRepository;

@RestController
@RequestMapping("/rest/login")
@CrossOrigin(origins = "*")
public class LoginRestController {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private LoginRepository loginRepository;
	
	@GetMapping({ "", "/" })
	public ResponseEntity<Void> login(@Valid @RequestBody Login login,BindingResult br) {
		
		if(br.hasErrors()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		Login l = new Login();
		l.setLogin(login.getLogin());
		l.setPassword(passwordEncoder.encode(login.getPassword()));
		Example<Login> example = Example.of(l);
		Optional<Login> opt = loginRepository.findOne(example);
		
		if(opt.isPresent())
		
			return new ResponseEntity<>(HttpStatus.OK);
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	
}
