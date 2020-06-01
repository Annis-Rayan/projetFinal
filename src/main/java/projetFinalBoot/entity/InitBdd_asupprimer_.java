package projetFinalBoot.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import projetFinalBoot.service.AnimalService;
import projetFinalBoot.service.LocalisationService;
import projetFinalBoot.service.ObservationService;
import projetFinalBoot.service.UtilisateurService;

@Component
public class InitBdd_asupprimer_ {
	@Autowired
	private ObservationService observationService;
	@Autowired
	private LocalisationService localisationService;
	@Autowired
	private UtilisateurService utilisateurService;
	@Autowired
	private AnimalService animalService;

	
	public void plop() throws ParseException {
		
		Localisation l1 = new Localisation();
		l1.setPays("france");
		l1.setRegion("normandie");
		l1.setLocalite("petaouch");
		localisationService.ajout(l1);
		
		Utilisateur u1 = new Utilisateur();
		u1.setPseudo("annis");
		utilisateurService.ajout(u1);
		
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

	public InitBdd_asupprimer_() {
	}
	
	
}
