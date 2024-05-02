package com.ostalf.petstore_for_testers.controller;

import com.ostalf.petstore_for_testers.model.Pet;
import com.ostalf.petstore_for_testers.repository.PetRepo;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@Slf4j
@RestController
public class PetController {
    @Autowired
    private PetRepo petRepo;

    @PostMapping("/pet/add")
    public Pet postPet(@RequestBody Pet requestBody) {
        Pet response = petRepo.save(requestBody);
        log.info("New row: " + petRepo.save(requestBody));
        return response;
    }

    @GetMapping("/pet/all")
    public List<Pet> getAllPets() {
        List<Pet> pets = petRepo.findAll();
        log.info("Get all pets: " + pets);
        return pets;
    }

    @GetMapping("/pet/{id}")
    public Pet getPetById(@PathVariable("id") int id) {
        Pet pet = petRepo.findById(id).orElseThrow();
        log.info("Add new row: " + pet);
        return pet;
    }

    @PatchMapping("/pet/{id}")
    public Pet patchPetById(@PathVariable("id") int id, @RequestBody Pet requestBody) {
        Pet pet = petRepo.findById(id).orElseThrow();
        pet.setName(requestBody.getName());
        pet.setId(id);
        log.info("Change row: " + petRepo.save(pet));
        return pet;
    }

    @DeleteMapping("/pet/{id}")
    public void deletePetById(@PathVariable("id") int id) {
        Pet pet = petRepo.findById(id).orElseThrow();
        petRepo.delete(pet);
        log.info("Delete row where id: " + id);
    }
}
