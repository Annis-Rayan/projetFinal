package projetFinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import projetFinal.entity.Utilisateur;

public interface UtilisateurRepository extends JpaRepository <Utilisateur, Integer> {

}
