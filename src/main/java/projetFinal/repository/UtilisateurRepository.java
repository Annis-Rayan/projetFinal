package projetFinal.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import projetFinal.entity.Utilisateur;

public interface UtilisateurRepository extends JpaRepository <Utilisateur, Integer> {

	
	Optional<Utilisateur> findByPseudo(String pseudo);
	
	@Query("select u from Utilisateur u left join fetch u.observations where u.pseudo=:pseudo")
	Optional<Utilisateur> findByPseudoWithObservations(@Param("pseudo") String pseudo);
	
	@Query("select u from Utilisateur u left join fetch u.observations where u.id=:id")
	Optional<Utilisateur> findByIdWithObservations(@Param("id") Integer id);
}
