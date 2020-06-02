package projetFinalBoot.restController;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import projetFinalBoot.entity.Login;
import projetFinalBoot.entity.LoginRole;
import projetFinalBoot.entity.Role;
import projetFinalBoot.repository.LoginRepository;
import projetFinalBoot.repository.LoginRoleRepository;


@RestController
@RequestMapping("/rest/inscription")
@CrossOrigin(origins = "*")
public class InscriptionRestController {

	@Autowired
	private LoginRepository loginRepository;
	@Autowired
	private LoginRoleRepository LoginRoleRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PostMapping({"","/"})
	public ResponseEntity<Void> inscription(@Valid @RequestBody Login login,BindingResult br){
		if(br.hasErrors()) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
		Optional<Login> optional=loginRepository.findById(login.getLogin());
		if(optional.isPresent()) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		login.setEnable(true);
		login.setPassword(passwordEncoder.encode(login.getPassword()));
		loginRepository.save(login);
		LoginRole role=new LoginRole();
		role.setLogin(login);
		role.setRole(Role.ROLE_USER);
		LoginRoleRepository.save(role);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@GetMapping("/{login}")
	public ResponseEntity<Boolean> loginDispo(@PathVariable("login")String login){
		Optional<Login>opt=loginRepository.findById(login);
		if(opt.isPresent()) {
			return new ResponseEntity<>(false,HttpStatus.OK);
		}
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}
}
