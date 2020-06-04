package projetFinalBoot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import projetFinalBoot.entity.Localisation;
import projetFinalBoot.service.LocalisationService;


@SpringBootTest
@Sql({"/suppr_shema.sql ", "/initbdd.sql"})
class LocalisationTest {

	@Autowired
	private LocalisationService localisationService;
	
	@Test
	public void findByIdTest() {
		assertTrue(localisationService.findById(99)!=null);
		
		try {
			localisationService.findById(2000);
		} catch (IllegalArgumentException e) {
			assertTrue(true);
			
		}
		
	}
	
	@Test
	public void saveLocalisationTest() {
		Localisation l =new Localisation();
		l.setPays("france");
		l.setRegion("bretagne");
		localisationService.save(l);
		
		Localisation l2=localisationService.findByRegion("bretagne").get(0);
		assertEquals("france", l2.getPays());
		assertEquals("bretagne", l2.getRegion());
		assertEquals("non defini",l2.getLocalite());
	}

	@Test
	public void updateLocalisationTest() {
		Localisation l = localisationService.findById(99).get();
		l.setLocalite("chezmoi");
		try {
			localisationService.update(l);
		} catch (Exception e) {
			
			assertTrue(false);
		}
		
		assertEquals("chezmoi", localisationService.findById(99).get().getLocalite());
	}
	

	@Test
	public void deleteLocalisationTest() {
		localisationService.deleteById(99);
		Localisation a = new Localisation();
		try {
		a= localisationService.findById(99).get();
		
	} catch (IllegalArgumentException e) {
		assertTrue(true);
		
	}
	assertEquals(a.getId(),null);
		
	}
	
	
	
}
