package com.ostalf.petstore_for_testers.repository;

import com.ostalf.petstore_for_testers.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Integer> {
}
