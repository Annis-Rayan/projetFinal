package projetFinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import projetFinal.entity.Observation;

public interface ObservationRepositery extends JpaRepository<Observation, Integer>{

}
