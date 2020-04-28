package formationJpa;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import formationJpa.context.Context;
import formationJpa.dao.DaoCompetence;
import formationJpa.dao.DaoCompetenceFactory;
import formationJpa.dao.DaoFormation;
import formationJpa.dao.DaoFormationFactory;
import formationJpa.dao.DaoMatiere;
import formationJpa.dao.DaoMatiereFactory;
import formationJpa.dao.DaoPersonne;
import formationJpa.dao.DaoPersonneFactory;
import formationJpa.dao.DaoSalle;
import formationJpa.dao.DaoSalleFactory;
import formationJpa.entity.Competence;
import formationJpa.entity.CompetencePK;
import formationJpa.entity.Formateur;
import formationJpa.entity.Formation;
import formationJpa.entity.Matiere;
import formationJpa.entity.Salle;
import formationJpa.entity.Stagiaire;

public class TestJointure {

	public static void main(String[] args) {
		
		
		DaoPersonne daoPersonne = DaoPersonneFactory.getInstance();
		
		
		DaoFormation daoFormation = DaoFormationFactory.getInstance();
		
		
		List<Formateur> list = daoPersonne.findAllCompetences();
		
		for(Formateur f:list) {
			System.out.println(f.getPrenom());
			for(Competence c:f.getCompetences()) {
				System.out.println(c.getId().getMatiere().getNom());
			}
		}
		
//		System.out.println(daoFormation.findByKeyWithStagiaires(2).get().getStagiaires());
//		
//		daoFormation.findAll();
//		System.out.println("-----------");
		
//		List<Formation> formations = daoFormation.findAllWithStagiaires();
//		System.out.println(formations);
//		for(Formation f : formations) {
//			System.out.println(f.getId() + " " + f.getNom());
//			System.out.println(f.getStagiaires());
//		}
//		
//		Formateur f1 = new Formateur("olivier", "gozlan");
//		daoPersonne.insert(f1);
//		
//		Formateur f2 = new Formateur("jacky", "s");
//		daoPersonne.insert(f2);
//		
//		
//		Matiere m1 = new Matiere("java");
//		Matiere m2 = new Matiere("html");
//		
//		DaoMatiere daoMatiere = DaoMatiereFactory.getInstance();
//		
//		daoMatiere.insert(m2);
//		daoMatiere.insert(m1);
//		
//		Competence c1 = new Competence(new CompetencePK(f1, m1), "+");
//		
//		DaoCompetence daoCompetence = DaoCompetenceFactory.getInstance();
//		daoCompetence.insert(c1);
//		
//		System.out.println("------------");
//		daoCompetence.findAll();

		Context.destroy();

	}

}
