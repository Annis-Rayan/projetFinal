package projetFinalBoot;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import projetFinalBoot.entity.Animal;
import projetFinalBoot.service.AnimalService;
import projetFinalBoot.service.LocalisationService;
import projetFinalBoot.service.ObservationService;
import projetFinalBoot.service.UtilisateurService;


@SpringBootTest
@Sql({"/suppr_shema.sql ", "/initbdd.sql"})//TODO inserer utilisateur,localisation id=1
public class ConnexionBDDcreateTest {
	
	@Autowired
	private ObservationService observationService;
	@Autowired
	private LocalisationService localisationService;
	@Autowired
	private UtilisateurService utilisateurService;
	@Autowired
	private AnimalService animalService;
	
	@BeforeAll
	public static void initSpring() throws ParseException
	{	
	}
	
	@Test
	public void find() {
		assert(observationService.recherche(100)!=null);
		
		try {
			observationService.recherche(2000);
		} catch (IllegalArgumentException e) {
			assert(true);
			
		}
	}
	@Test
	public void suppressionAnimal() throws Exception {
		Animal vraiA= animalService.findbyId(100);
		Animal fauxA= animalService.findbyId(101);
		observationService.suppressionAnimal(vraiA, fauxA);
		assertFalse(true);
		
	}
	
	@Test
	public void miseAjourAnimal() {
		
		
	}
	
	
	
}
