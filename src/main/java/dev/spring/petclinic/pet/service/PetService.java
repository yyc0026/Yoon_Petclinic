package dev.spring.petclinic.pet.service;

import dev.spring.petclinic.pet.controller.dto.PetRes;
import dev.spring.petclinic.pet.model.Pet;
import java.util.List;

public interface PetService {
	List<Pet> getPetsByOwner(Long ownerId);  // 주어진 ownerId에 해당하는 Pet 리스트를 반환
	void addPet(Long ownerId, PetRes petRes);  // 새로운 Pet을 추가
}
