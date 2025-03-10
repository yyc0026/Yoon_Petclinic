package dev.spring.petclinic.pet.service;

import dev.spring.petclinic.pet.controller.dto.PetRes;
import dev.spring.petclinic.pet.model.Pet;
import dev.spring.petclinic.pet.repository.PetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PetServiceImpl implements PetService {
	private final PetRepository petRepository;

	@Override
	public List<Pet> getPetsByOwner(Long ownerId) {
		return petRepository.findByOwnerId(ownerId);  // JPA 방식으로 호출
	}

	@Override
	public void addPet(Long ownerId, PetRes petRes) {
		// PetRes 객체를 Pet 객체로 변환
		Pet pet = Pet.builder()
				.ownerId(ownerId)
				.name(petRes.getName())
				.birthDate(petRes.getBirthDate())
				.typeId(petRes.getType())  // 예시로 TypeId를 petRes에서 가져오는 방식
				.build();

		// 변환된 Pet 객체를 저장
		petRepository.save(pet);
	}
}
