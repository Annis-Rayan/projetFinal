package projetFinalBoot;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.jdbc.Sql;
import static org.junit.jupiter.api.Assertions.*;

import projetFinalBoot.entity.Animal;
import projetFinalBoot.entity.Localisation;
import projetFinalBoot.entity.Login;
import projetFinalBoot.entity.LoginRole;
import projetFinalBoot.entity.Observation;
import projetFinalBoot.entity.Role;
import projetFinalBoot.entity.TypeUtilisateur;
import projetFinalBoot.entity.Utilisateur;
import projetFinalBoot.models.ImageModel;
import projetFinalBoot.repository.ImageRepository;
import projetFinalBoot.repository.LoginRepository;
import projetFinalBoot.repository.LoginRoleRepository;
import projetFinalBoot.service.AnimalService;
import projetFinalBoot.service.ObservationService;
import projetFinalBoot.service.UtilisateurService;


@SpringBootTest
@Sql({"/suppr_shema.sql ", "/initbdd.sql"})//TODO inserer utilisateur,localisation id=1
public class ConnexionBDDcreateTest {
	
	@Autowired
	private ImageRepository imageRepository;
	@Autowired
	private UtilisateurService utilisateurService;
	@Autowired
	private ObservationService observationService;
	@Autowired
	private AnimalService animalService;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private LoginRepository loginRepository;
	@Autowired 
	private UtilisateurService utilisateurservice;
	
	@Test
	public void find() throws IOException {
		
		File file = new File("C:\\Users\\Amendil\\Pictures\\ad.PNG");
		
		
		Utilisateur user = utilisateurService.findById(1).get();
		ImageModel img = new ImageModel(file.getName(),"image/jpeg",Files.readAllBytes(file.toPath()));
		if (user.getImageProfil()!=null) {
			imageRepository.deleteById(user.getImageProfil().getId());
		}
		user.setImageProfil(img);
        
        imageRepository.save(img);
        utilisateurService.save(user);
	}
	
	
	@Test
	public void help() {
		
		Animal a =animalService.findById(99).get();
		Utilisateur u = utilisateurService.findById(1).get();
		
		Localisation l =new Localisation();
		l.setPays("france");
		l.setRegion("bretagne");
		l.setLocalite("plouc");
		
		Observation o = new Observation();
		o.setAnimal(a);
		o.setDateObservation(new Date());
		o.setDescription("ououu");
		o.setLocalisation(l);
		o.setNombre(5);
		o.setUtilisateur(u);
		
		observationService.save(o);
	}
	
	@Test
	public void pitie() {
		
		Login login =new Login();
		login.setLogin("toto");
		login.setPassword("bwwwa");
		
		login.setEnable(true);
		login.setPassword(passwordEncoder.encode(login.getPassword()));
		loginRepository.save(login);
		LoginRole role=new LoginRole();
		role.setLogin(login);
		role.setRole(Role.ROLE_USER);
		
		Utilisateur u =new Utilisateur();
		u.setPseudo(login.getLogin());
		u.setType(TypeUtilisateur.USER);
		utilisateurservice.save(u);

		u=utilisateurservice.findByPseudo(u.getPseudo()).get();
		
		login.setUtilisateur(u);
		
		loginRepository.save(login);
	}
	
	
	
	@Test
	public void unpeuencore() {
		
		Login login =new Login();
		login.setLogin("toto");
		login.setPassword("bwwwa");
		
		login.setEnable(true);
		login.setPassword(passwordEncoder.encode(login.getPassword()));
		loginRepository.save(login);
		LoginRole role=new LoginRole();
		role.setLogin(login);
		role.setRole(Role.ROLE_USER);
		
		Utilisateur u =new Utilisateur();
		u.setPseudo(login.getLogin());
		u.setType(TypeUtilisateur.USER);
		utilisateurservice.save(u);

		u=utilisateurservice.findByPseudo(u.getPseudo()).get();
		
		login.setUtilisateur(u);
		
		loginRepository.save(login);
		
		Optional<Login> opt = loginRepository.findByName("toto");
		
		if (opt.isPresent()) 
			assertEquals( passwordEncoder.matches("bwwwa",opt.get().getPassword()),true);
		
		else
			fail();
		
		//System.out.println(opt.get(0).getLogin());
	}
	
	@Test
	public void erreur() {
		
		Login login =new Login();
		login.setLogin("toto");
		login.setPassword("bwwwaa");
		
		login.setEnable(true);
		login.setPassword(passwordEncoder.encode(login.getPassword()));
		loginRepository.save(login);
		LoginRole role=new LoginRole();
		role.setLogin(login);
		role.setRole(Role.ROLE_USER);
		
		Utilisateur u =new Utilisateur();
		u.setPseudo(login.getLogin());
		u.setType(TypeUtilisateur.USER);
		utilisateurservice.save(u);

		u=utilisateurservice.findByPseudo(u.getPseudo()).get();
		
		login.setUtilisateur(u);
		
		loginRepository.save(login);
		
		Optional<Login> opt = loginRepository.findByName("toto");
		
		if (opt.isPresent()) 
			assertEquals( passwordEncoder.matches("bwwwa",opt.get().getPassword()),false);
		
		else
			fail();
		
		//System.out.println(opt.get(0).getLogin());
	}
	
	@Test
	public void erreur2() {
		
		Optional<Login> opt = loginRepository.findByName("tota");
		
		if (opt.isPresent()) 
			fail();
		
		else {
			assertTrue(true);
		}
			
		
		//System.out.println(opt.get(0).getLogin());
	}
}
