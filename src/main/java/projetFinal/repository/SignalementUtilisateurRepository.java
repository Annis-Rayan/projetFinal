package projetFinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import projetFinal.entity.SignalementUtilisateur;
import projetFinal.entity.Utilisateur;

public interface SignalementUtilisateurRepository extends JpaRepository <SignalementUtilisateur, Utilisateur>{

}
