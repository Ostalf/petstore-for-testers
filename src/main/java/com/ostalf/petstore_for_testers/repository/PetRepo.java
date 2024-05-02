package com.ostalf.petstore_for_testers.repository;

import com.ostalf.petstore_for_testers.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepo extends JpaRepository<Pet, Integer> {
}
