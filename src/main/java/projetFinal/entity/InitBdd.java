package projetFinal.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import projetFinal.config.AppConfig;
import projetFinal.service.AnimalService;
import projetFinal.service.LocalisationService;
import projetFinal.service.ObservationService;
import projetFinal.service.UtilisateurService;

public class InitBdd {
	private ObservationService observationService;
	private LocalisationService localisationService;
	private UtilisateurService utilisateurService;
	private AnimalService animalService;
	private static AnnotationConfigApplicationContext ctx;
	
	public void plop(AnnotationConfigApplicationContext ctx) throws ParseException {
		
		localisationService = ctx.getBean(LocalisationService.class);
		Localisation l1 = new Localisation();
		l1.setPays("france");
		l1.setRegion("normandie");
		l1.setLocalite("petaouch");
		localisationService.ajout(l1);
		
		utilisateurService = ctx.getBean(UtilisateurService.class);
		Utilisateur u1 = new Utilisateur();
		u1.setPseudo("annis");
		utilisateurService.ajout(u1);
		
		animalService = ctx.getBean(AnimalService.class);
		Animal a1 = new Animal();
		a1.setNomCourant("chat");
		a1.setDescription("c'est un chat");
		animalService.ajout(a1);
		
		Animal a2 = new Animal();
		a2.setNomCourant("chien");
		a2.setDescription("c'est un chien");
		animalService.ajout(a2);

		Animal a3 = new Animal();
		a3.setNomCourant("souris");
		a3.setDescription("c'est une souris");
		animalService.ajout(a3);
		
			
		
		observationService = ctx.getBean(ObservationService.class);

		Observation o1 = new Observation();
		String sDate1 = "31/12/1998";
		SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");
		Date date1 = formatter1.parse(sDate1);
		o1.setDateObservation(date1);
		o1.setDescription("c'est un chat  qui court");
		o1.setNombre(3);
		o1.setAnimal(a1);
		o1.setLocalisation(l1);
		o1.setUtilisateur(u1);
		observationService.ajout(o1);
		

		Observation o2 = new Observation();
		o2.setDateObservation(date1);
		o2.setDescription("c'est un chien  qui court");
		o2.setNombre(3);
		o2.setAnimal(a2);
		o2.setLocalisation(l1);
		o2.setUtilisateur(u1);
		observationService.ajout(o2);
		
		Observation o3 = new Observation();
		o3.setDateObservation(date1);
		o3.setDescription("c'est une souris qui court");
		o3.setNombre(3);
		o3.setAnimal(a3);
		o3.setLocalisation(l1);
		o3.setUtilisateur(u1);
		observationService.ajout(o3);
		
		
		
		
		
		
		
		
	}

	public InitBdd() {
	}
	
	
}
