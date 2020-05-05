package formationJpa;

import projetFinal.dao.DaoSignalement;
import projetFinal.dao.DaoSignalementFactory;
import projetFinal.dao.DaoUtilisateur;
import projetFinal.dao.DaoUtilisateurFactory;
import projetFinal.entity.Signalement;
import projetFinal.entity.SignalementObservation;
import projetFinal.entity.Utilisateur;

public class TestAnnis {

	public static void main(String[] args) {
		Utilisateur u1 = new Utilisateur();
		
		System.out.println("_______________");
		
		DaoUtilisateur daoUtilisateur = DaoUtilisateurFactory.getInstance();
		
		System.out.println("_______________");
		
		
		u1.setPseudo("Annis");
		
		System.out.println("_______________");
		
		daoUtilisateur.insert(u1);
		System.out.println("_______________");
		
		
		Signalement s1 = new SignalementObservation();
		
		DaoSignalement daoSignalement = DaoSignalementFactory.getInstance();
		
		s1.setDescription("observation fausse");
		
		daoSignalement.insert(s1);

	}

}
