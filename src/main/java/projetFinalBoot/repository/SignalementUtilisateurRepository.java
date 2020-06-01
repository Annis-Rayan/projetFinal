package projetFinalBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import projetFinalBoot.entity.SignalementUtilisateur;
import projetFinalBoot.entity.Utilisateur;

public interface SignalementUtilisateurRepository extends JpaRepository <SignalementUtilisateur, Utilisateur>{

}
