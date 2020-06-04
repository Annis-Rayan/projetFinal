package projetFinalBoot;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import projetFinalBoot.entity.Animal;
import projetFinalBoot.entity.Localisation;
import projetFinalBoot.entity.Observation;
import projetFinalBoot.entity.Utilisateur;
import projetFinalBoot.models.ImageModel;
import projetFinalBoot.repository.AnimalRepository;
import projetFinalBoot.repository.ImageRepository;
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
	
	@Test
	public void find() throws IOException {
		
		File file = new File("C:\\Users\\Amendil\\Pictures\\ad.PNG");
		
		
		Utilisateur user = utilisateurService.findById(1).get();
		ImageModel img = new ImageModel(file.getName(),"image/jpeg",Files.readAllBytes(file.toPath()));
		if (user.getImageProfil()!=null) {
			imageRepository.deleteById(user.getImageProfil().getId());
		}
		user.setImageProfil(img);
        
        final ImageModel savedImage = imageRepository.save(img);
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
	
}
