package projetFinalBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import projetFinalBoot.entity.Observation;
import projetFinalBoot.entity.SignalementObservation;

public interface SignalementObservationRepository extends JpaRepository<SignalementObservation, Observation>{

}
