package projetFinalBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import projetFinalBoot.entity.Localisation;


public interface LocalisationRepository extends JpaRepository<Localisation, Integer> {
	
	
}
