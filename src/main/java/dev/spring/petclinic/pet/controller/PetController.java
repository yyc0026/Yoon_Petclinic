package dev.spring.petclinic.pet.controller;

import dev.spring.petclinic.owner.model.Owner;
import dev.spring.petclinic.owner.repository.OwnerRepository;
import dev.spring.petclinic.pet.model.Pet;
import dev.spring.petclinic.pet.service.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/owners/{ownerId}/pets")
@RequiredArgsConstructor
public class PetController {

	private final PetService petService;
	private final OwnerRepository ownerRepository;

	@GetMapping
	public String getPets(@PathVariable Long ownerId, Model model) {
		List<Pet> pets = petService.getPetsByOwner(ownerId);
		Owner owner = ownerRepository.findOwnerById(ownerId).orElseThrow();

		model.addAttribute("owner", owner);
		model.addAttribute("pets", pets);
		return "owners/ownerDetails";
	}

	@PostMapping("/new")
	public String addPet(@PathVariable Long ownerId, @ModelAttribute Pet pet, RedirectAttributes redirectAttributes) {
		Owner owner = ownerRepository.findOwnerById(ownerId).orElseThrow();
		pet.setOwner(owner);
		petService.addPet(pet);
		redirectAttributes.addFlashAttribute("success", "New pet added successfully!");
		return "redirect:/owners/" + ownerId;
	}
}
