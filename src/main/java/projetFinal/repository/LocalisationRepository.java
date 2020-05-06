package projetFinal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import projetFinal.entity.Localisation;


public interface LocalisationRepository extends JpaRepository<Localisation, Integer> {
	
	
}
