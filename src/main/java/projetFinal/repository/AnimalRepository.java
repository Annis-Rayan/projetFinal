package projetFinal.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import projetFinal.entity.Animal;

public interface AnimalRepository extends JpaRepository<Animal, Integer> {

	@Query ("select a from Animal a left join fetch a.nomCourant where a.nomCourant=:nomCourant")
	Optional<Animal> findByNomCourant(@Param("nomCourant")String nomCourant);
	
}
