package projetFinalBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import projetFinalBoot.entity.Observation;

public interface ObservationRepository extends JpaRepository<Observation, Integer> {

	
}
