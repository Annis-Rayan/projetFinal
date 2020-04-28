package formationJpa;

import projetFinal.dao.DaoUtilisateur;
import projetFinal.dao.DaoUtilisateurFactory;
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

	}

}
