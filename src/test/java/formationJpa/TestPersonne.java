package formationJpa;

import formationJpa.context.Context;
import formationJpa.dao.DaoPersonne;
import formationJpa.dao.DaoPersonneFactory;
import formationJpa.entity.Adresse;
import formationJpa.entity.Formateur;
import formationJpa.entity.Personne;
import formationJpa.entity.Stagiaire;

public class TestPersonne {

	public static void main(String[] args) {
		DaoPersonne daoPersonne = DaoPersonneFactory.getInstance();
		
		Formateur olivier = new Formateur("o", "g");
		System.out.println(olivier.getId());
		olivier.setAdresse(new Adresse(1, "rue x","75000","paris"));
		
		olivier.setExperience(20);
	
		daoPersonne.insert(olivier);
		System.out.println(olivier.getId());
		
		daoPersonne.insert(new Stagiaire("aa", "bb"));
		System.out.println("------------");
		System.out.println(daoPersonne.findByKey(olivier.getId()).get().getNom());
		System.out.println("------------");
		System.out.println(daoPersonne.findAllStagiaires());
		
		Context.destroy();

	}

}
