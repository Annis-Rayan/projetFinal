package projetFinalBoot;

import static org.junit.jupiter.api.Assertions.assertFalse;

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
@Sql({"/suppr_shema.sql ", "/initbdd.sql"})
public class AnimalTest {
	
	@Autowired
	private ObservationService observationService;
	@Autowired
	private LocalisationService localisationService;
	@Autowired
	private UtilisateurService utilisateurService;
	@Autowired
	private AnimalService animalService;
	
	@Test
	public void findByIdTest() {
		
		
	}
	
	@Test
	public void findByNomTest() {
		
		
	}
	
	@Test
	public void saveAnimalTest() {
		
		
	}
	
	@Test
	public void deleteAnimalDoublonTest() throws Exception {
		Animal vraiA= animalService.findById(100).get();
		Animal fauxA= animalService.findById(101).get();
		observationService.deleteAnimalDoublon(vraiA, fauxA);
		assertFalse(true);
		
	}
	
	@Test
	public void updateAnimalTest() {
		
		
	}
	
	@Test
	public void deleteAnimalTest() {
		
		
	}
	
	@Test
	public void findAllAnimalTest() {
		
		
	}
	
	
}
