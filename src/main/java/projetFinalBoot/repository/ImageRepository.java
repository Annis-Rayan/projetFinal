package projetFinalBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import projetFinalBoot.models.ImageModel;

public interface ImageRepository extends JpaRepository<ImageModel, Long> {
}