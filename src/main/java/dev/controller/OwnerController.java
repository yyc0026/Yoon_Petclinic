package dev.controller;

import dev.Model.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import dev.service.OwnerService;

import java.util.List;

@RestController
@RequestMapping("/api/owners")
public class OwnerController {
    private final OwnerService ownerService;

    @Autowired
    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @GetMapping("/all")
    public List<Owner> getAllOwners() {
        return ownerService.findAllOwners();
    }

    @GetMapping
    public List<Owner> getOwnersByLastName(@RequestParam String lastName) {
        return ownerService.findByLastName(lastName);
    }

    @PostMapping
    public ResponseEntity<String> createOwner(@RequestBody Owner owner) {
        ownerService.saveOwner(owner);
        return ResponseEntity.ok("Owner registered successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOwner(@PathVariable Long id) {
        ownerService.deleteOwner(id);
        return ResponseEntity.ok("Owner deleted successfully");
    }
}

