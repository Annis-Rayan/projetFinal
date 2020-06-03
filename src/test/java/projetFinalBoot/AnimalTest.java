package projetFinalBoot;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import projetFinalBoot.entity.Animal;
import projetFinalBoot.entity.Ordre;
import projetFinalBoot.service.AnimalService;
import projetFinalBoot.service.ObservationService;



@SpringBootTest
@Sql({"/suppr_shema.sql ", "/initbdd.sql"})
public class AnimalTest {
	
	@Autowired
	private ObservationService observationService;
	@Autowired
	private AnimalService animalService;
	
	@Test
	public void findByIdTest() {
		assertTrue(animalService.findById(99)!=null);
		
		try {
			animalService.findById(2000);
		} catch (IllegalArgumentException e) {
			assertTrue(true);
			
		}
		
	}
	
	@Test
	public void findByNomTest() {
		assertTrue(animalService.findByNom("chat")!=null);
		
		int x=0;
			try {
			x=animalService.findByNom("plop").size();
			
			
		} catch (IllegalArgumentException e) {
			assertTrue(true);
			
		}
			
		assertEquals(x,0);

	}
	
	@Test
	public void saveAnimalTest() {
		Animal a = new Animal();
		a.setDescription("ouiii");
		a.setNomCourant("mouche");
		animalService.save(a);
		
		Animal a2=animalService.findByNom("mouche").get(0);
		assertEquals("non defini", a2.getNomScientifique());
		assertEquals("mouche", a2.getNomCourant());
	}
	
	@Test
	public void deleteAnimalDoublonTest() throws Exception {
		Animal vraiA= animalService.findById(99).get();
		Animal fauxA= animalService.findById(98).get();
		observationService.deleteAnimalDoublon(vraiA, fauxA);
		
		try {
			animalService.findById(98);
			
			assertTrue(false);
		} catch (IllegalArgumentException e) {
			assertTrue(true);
		}
		
		assertEquals(observationService.findById(98).get().getAnimal().getId(),99);
		
		
	}
	
	@Test
	public void updateAnimalTest() {
		Animal a = animalService.findById(99).get();
		a.setDescription("bbb");
		try {
			animalService.update(a);
		} catch (Exception e) {
			
			assertTrue(false);
		}
		
		assertEquals("bbb", animalService.findById(99).get().getDescription());
	}
	
	@Test
	public void deleteAnimalTest() {
		animalService.deleteById(99);
		Animal a = new Animal();
		try {
		a= animalService.findById(99).get();
		
	} catch (IllegalArgumentException e) {
		assertTrue(true);
		
	}
	assertEquals(a.getId(),null);
		
	}
	
	@Test
	public void findAllAnimalTest() {
		assertEquals(animalService.findAll().size(), 3);
		
	}
	
	@Test
	public void findByNomContainsTest() {
		
		assertEquals("souris", animalService.findByNomContains("sou").get(0).getNomCourant());
		
	}
	
	@Test
	public void findByOrdreTest() {
		Animal a =new Animal();
		a.setNomCourant("babouin");
		a.setOrdre(Ordre.Mammifere);
		animalService.save(a);
		
		assertEquals("babouin", animalService.findByOrdre(Ordre.Mammifere).get(0).getNomCourant());
		
	}
	
	@Test
	public void findByNomScientifiqueTest() {
		Animal a =new Animal();
		a.setNomCourant("babouin");
		a.setNomScientifique("baba");
		animalService.save(a);
		
		Animal a2 = animalService.findById(99).get();
		a2.setNomScientifique("babb");
		try {
			animalService.update(a2);
		} catch (Exception e) {
			
			assertTrue(false);
		}
		
		assertEquals(2, animalService.findByNomScientifique("ba").size());
	}
	
}
