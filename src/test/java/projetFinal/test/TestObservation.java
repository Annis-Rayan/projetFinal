package ProjetFinal.test;

import static org.junit.Assert.assertTrue;

import java.text.ParseException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import projetFinal.config.AppConfig;
import projetFinal.entity.Animal;
import projetFinal.entity.InitBdd;
import projetFinal.exception.NoObservationFoundException;
import projetFinal.service.AnimalService;
import projetFinal.service.LocalisationService;
import projetFinal.service.ObservationService;
import projetFinal.service.UtilisateurService;



public class TestObservation {
	private ObservationService observationService;
	private LocalisationService localisationService;
	private UtilisateurService utilisateurService;
	private AnimalService animalService;
	private static AnnotationConfigApplicationContext ctx;
	
	@BeforeClass
	public static void initSpring() throws ParseException {
		ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		InitBdd i=new InitBdd();
		i.plop(ctx);
		
	}
	
	@AfterClass
	public static void closeSpring() {
		ctx.close();
	}
	
	@Before
	public void initRepo() {
		observationService = ctx.getBean(ObservationService.class);
		animalService = ctx.getBean(AnimalService.class);
		
	}
	
	@After
	public void close() {
		
	}
	@Test
	public void find() {
		assertTrue(observationService.recherche(100)!=null);
		
		try {
			observationService.recherche(2000);
		} catch (IllegalArgumentException e) {
			assertTrue(true);
			
		}
	}
	
	@Test
	public void suppressionAnimal() throws NoObservationFoundException {
		Animal vraiA= animalService.recherche(100);
		Animal fauxA= animalService.recherche(101);
		observationService.suppressionAnimal(vraiA, fauxA);
		assertTrue(true);
	}
	
	


	

}
