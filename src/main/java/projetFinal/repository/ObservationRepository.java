package projetFinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import projetFinal.entity.Observation;

public interface ObservationRepository extends JpaRepository<Observation, Integer>{

}
