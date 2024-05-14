package com.ostalf.petstore_for_testers.mapper;

import com.ostalf.petstore_for_testers.dto.CategoryResponseDto;
import com.ostalf.petstore_for_testers.dto.PetResponseDto;
import com.ostalf.petstore_for_testers.model.Pet;

import java.util.List;

public class PetMapper {
    public PetResponseDto toPetResponseDto(Pet pet) {
        return PetResponseDto.builder().id(pet.getId()).name(pet.getName()).age(pet.getAge()).categoryDto(CategoryResponseDto.builder().id(pet.getCategory().getId()).name(pet.getCategory().getName()).build()).build();
    }

    public List<PetResponseDto> toListPetResponseDto(List<Pet> petList) {
        return petList.stream().map(this::toPetResponseDto).toList();
    }
}
