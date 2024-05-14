package com.ostalf.petstore_for_testers.controller;

import com.ostalf.petstore_for_testers.dto.PetRequestDto;
import com.ostalf.petstore_for_testers.dto.PetResponseDto;
import com.ostalf.petstore_for_testers.model.Category;
import com.ostalf.petstore_for_testers.model.Pet;
import com.ostalf.petstore_for_testers.repository.CategoryRepo;
import com.ostalf.petstore_for_testers.repository.PetRepo;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.NoSuchElementException;
@Tag(name = "Pet Controller")
@Slf4j
@RestController
@RequiredArgsConstructor
public class PetController {
    @Autowired
    private PetRepo petRepo;
    @Autowired
    private CategoryRepo categoryRepo;

    @PostMapping("/pet/add")
    public PetResponseDto postPet(@NotNull @RequestBody PetRequestDto petRequestDto) {
        Pet pet = new Pet();
        Category category = new Category();
        PetResponseDto petResponseDto = new PetResponseDto();

        pet.setName(petRequestDto.getName());
        pet.setAge(petRequestDto.getAge());

        category.setId(petRequestDto.getCategoryId());

        pet.setCategory(category);
        try {
            Pet response = petRepo.save(pet);
            log.info("Add new row: " + response);

            petResponseDto.setId(pet.getId());
            petResponseDto.setName(pet.getName());
            petResponseDto.setAge(pet.getAge());
            petResponseDto.setCategory(categoryRepo.findById(String.valueOf(petRequestDto.getCategoryId())).orElseThrow());
            
            return petResponseDto;
        } catch (DataIntegrityViolationException e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, e.getMessage()
            );
        }
    }

    @GetMapping("/pet/all")
    public List<Pet> getAllPets() {
        List<Pet> pets = petRepo.findAll();
        log.info("Get all pets: " + pets);

        return pets;
    }

    @GetMapping("/pet/{id}")
    public Pet getPetById(@PathVariable("id") int id) {
        try {
            Pet pet = petRepo.findById(id).orElseThrow();
            log.info("Get row: " + pet);
            return pet;
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, e.getMessage()
            );
        }

    }

    @PutMapping("/pet/{id}")
    public Pet putPetById(@PathVariable("id") int id, @RequestBody Pet pet) {
        try {
            pet = petRepo.findById(id).orElseThrow();
            pet.setId(id);

            log.info("Change row: " + petRepo.saveAndFlush(pet));
            return pet;
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, e.getMessage()
            );
        } catch (DataIntegrityViolationException e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, e.getMessage()
            );
        }
    }

    @DeleteMapping("/pet/{id}")
    public void deletePetById(@PathVariable("id") int id) {
        try {
            Pet pet = petRepo.findById(id).orElseThrow();
            petRepo.delete(pet);
            log.info("Delete row where id: " + id);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, e.getMessage()
            );
        }
    }
}
