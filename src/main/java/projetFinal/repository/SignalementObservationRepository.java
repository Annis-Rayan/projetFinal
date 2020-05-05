package projetFinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import projetFinal.entity.Observation;
import projetFinal.entity.SignalementObservation;

public interface SignalementObservationRepository extends JpaRepository<SignalementObservation, Observation>{

}
