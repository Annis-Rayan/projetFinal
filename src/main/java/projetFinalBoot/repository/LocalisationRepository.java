package projetFinalBoot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import projetFinalBoot.entity.Localisation;


public interface LocalisationRepository extends JpaRepository<Localisation, Integer> {
	
	
}
