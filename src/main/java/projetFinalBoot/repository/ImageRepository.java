package projetFinalBoot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import projetFinalBoot.models.ImageModel;

public interface ImageRepository extends JpaRepository<ImageModel, Long> {
	Optional<ImageModel> findByName(String name);
}