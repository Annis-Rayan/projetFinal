package formationJpa;

import formationJpa.dao.DaoPersonne;
import formationJpa.dao.DaoPersonneFactory;
import formationJpa.entity.Adresse;
import formationJpa.entity.Formateur;

public class TestVersion {

	public static void main(String[] args) {
		Formateur formateur = new Formateur("olivier", "gozlan");
		DaoPersonne daoPersonne = DaoPersonneFactory.getInstance();
		daoPersonne.insert(formateur);
		formateur.setAdresse(new Adresse(1, "rue xxx", "91000", "ville du 91"));
		formateur = (Formateur)daoPersonne.update(formateur);
		formateur.setExperience(10);
		formateur = (Formateur)daoPersonne.update(formateur);
		daoPersonne.delete(formateur);
		

	}

}
