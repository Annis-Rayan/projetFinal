package projetFinalBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import projetFinalBoot.entity.Animal;

public interface AnimalRepository extends JpaRepository<Animal, Integer> {

}
