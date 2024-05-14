package com.ostalf.petstore_for_testers.controller;

import com.ostalf.petstore_for_testers.dto.CategoryRequestDto;
import com.ostalf.petstore_for_testers.dto.CategoryResponseDto;
import com.ostalf.petstore_for_testers.dto.PetResponseDto;
import com.ostalf.petstore_for_testers.mapper.CategoryMapper;
import com.ostalf.petstore_for_testers.mapper.PetMapper;
import com.ostalf.petstore_for_testers.model.Category;
import com.ostalf.petstore_for_testers.model.Pet;
import com.ostalf.petstore_for_testers.repository.CategoryRepo;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.NoSuchElementException;

@Tag(name = "Category Controller")
@Slf4j
@RestController
@RequiredArgsConstructor
public class CategoryController {
    @Autowired
    private CategoryRepo categoryRepo;

    @PostMapping("/category/add")
    public CategoryResponseDto postCategory(@RequestBody CategoryRequestDto categoryRequestDto) {
        try {
            Category category = new Category();
            category.setName(categoryRequestDto.getName());

            Category response = categoryRepo.save(category);
            log.info("Add new row: " + response);

            return new CategoryMapper().toCategoryResponseDto(response);

        } catch (DataIntegrityViolationException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @GetMapping("/category/all")
    public List<CategoryResponseDto> getAllCategory() {
        List<Category> categoryList = categoryRepo.findAll();
        log.info("Get all category: " + categoryList);

        return new CategoryMapper().toListPetResponseDto(categoryList);
    }

    @DeleteMapping("/category/{id}")
    public void deleteCategoryById(@PathVariable("id") int id) {
        try {
            Category category = categoryRepo.findById(id).orElseThrow();
            categoryRepo.delete(category);
            log.info("Delete row where id: " + id);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        } catch (DataIntegrityViolationException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage());
        }
    }
}
