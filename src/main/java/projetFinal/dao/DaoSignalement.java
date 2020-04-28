package projetFinal.dao;

import java.util.List;

import projetFinal.entity.Signalement;
import projetFinal.entity.SignalementObservation;
import projetFinal.entity.SignalementUtilisateur;

public interface DaoSignalement extends DaoGeneric<Signalement, Integer>{
	
	List<SignalementObservation> findAllSignalementObservation();
	List<SignalementUtilisateur> findAllSignalementUtilisateur();
	
	
}
