package com.ostalf.petstore_for_testers.controller;

import com.ostalf.petstore_for_testers.model.Category;
import com.ostalf.petstore_for_testers.repository.CategoryRepo;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@Tag(name = "Category Controller")
@Slf4j
@RestController
@RequiredArgsConstructor
public class CategoryController {
    @Autowired
    private CategoryRepo categoryRepo;

    @PostMapping("/category/add")
    public void postCategory(@RequestBody Category category) {
        try {
            log.info("Add new row: " + categoryRepo.save(category));
        } catch (DataIntegrityViolationException e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, e.getMessage()
            );
        }
    }
}
