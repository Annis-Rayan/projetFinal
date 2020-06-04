package projetFinalBoot.restController;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
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
import projetFinalBoot.entity.TypeUtilisateur;
import projetFinalBoot.entity.Utilisateur;
import projetFinalBoot.models.ImageModel;
import projetFinalBoot.repository.LoginRepository;
import projetFinalBoot.repository.LoginRoleRepository;
import projetFinalBoot.service.UtilisateurService;


@RestController
@RequestMapping("/rest/inscription")
@CrossOrigin(origins = "*")
public class InscriptionRestController {

	@Autowired
	private LoginRepository loginRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired 
	private UtilisateurService utilisateurservice;
	
	
	
	@PostMapping({"","/"})
	public ResponseEntity<Utilisateur> inscription(@Valid @RequestBody Login login,BindingResult br) throws IOException{
		if(br.hasErrors()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Optional<Login> optional=loginRepository.findByName(login.getLogin());
		if(optional.isPresent()) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		login.setEnable(true);
		login.setPassword(passwordEncoder.encode(login.getPassword()));
		loginRepository.save(login);
		LoginRole role=new LoginRole();
		role.setLogin(login);
		role.setRole(Role.ROLE_USER);
		
		
		Utilisateur u =new Utilisateur();
		u.setPseudo(login.getLogin());
		u.setType(TypeUtilisateur.USER);
		
		//File file = new File("profiledefault.png");
		//ImageModel img = new ImageModel(file.getName(),"image/jpeg",Files.readAllBytes(file.toPath()));
		//u.setImageProfil(img);
		utilisateurservice.save(u);
		
		u=utilisateurservice.findByPseudo(u.getPseudo()).get();
		login.setUtilisateur(u);
		
		loginRepository.save(login);
		
		return new ResponseEntity<Utilisateur>(u,HttpStatus.CREATED);
	}
	
	@GetMapping("/{login}")
	public ResponseEntity<Boolean> loginDispo(@PathVariable("login")String id){
		Optional<Login>opt=loginRepository.findByName(id);
		if(opt.isPresent()) {
			return new ResponseEntity<>(false,HttpStatus.OK);
		}
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}
}
