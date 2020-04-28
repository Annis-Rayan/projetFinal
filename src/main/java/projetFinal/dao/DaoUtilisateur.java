package projetFinal.dao;

import java.util.Optional;

import projetFinal.entity.Utilisateur;

public interface DaoUtilisateur extends DaoGeneric<Utilisateur, Integer> {
	
	Optional<Utilisateur> findByPseudo(String pseudo);
}
