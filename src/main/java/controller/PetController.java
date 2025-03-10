package controller;

import Model.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.PetService;

import java.util.List;

@RestController
@RequestMapping("/api/pets")
public class PetController {
    private final PetService petService;

    @Autowired
    public PetController(PetService petService) {
        this.petService = petService;
    }

    @GetMapping("/{ownerId}")
    public List<Pet> getPetsByOwner(@PathVariable Long ownerId) {
        return petService.findPetsByOwnerId(ownerId);
    }

    @PostMapping
    public ResponseEntity<String> createPet(@RequestBody Pet pet) {
        petService.savePet(pet);
        return ResponseEntity.ok("Pet registered successfully");
    }
}
