package dev.spring.petclinic.pet.repository;

import dev.spring.petclinic.pet.controller.dto.PetRes;
import dev.spring.petclinic.pet.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PetRepository extends JpaRepository<Pet, Long> {
	// ownerId로 pets를 조회하는 메서드
	List<Pet> findByOwnerId(Long ownerId);
}
