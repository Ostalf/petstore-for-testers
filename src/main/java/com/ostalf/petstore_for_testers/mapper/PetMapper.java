package com.ostalf.petstore_for_testers.mapper;

import com.ostalf.petstore_for_testers.dto.PetRequestDto;
import com.ostalf.petstore_for_testers.dto.PetResponseDto;
import com.ostalf.petstore_for_testers.model.Pet;

import java.util.List;

public class PetMapper {
    public PetRequestDto toPetRequestDto(Pet pet) {
        return PetRequestDto.builder()
                .name(pet.getName())
                .age(pet.getAge())
                .categoryId(pet.getCategory().getId())
                .build();
    }

    public PetResponseDto toPetResponseDto(Pet pet) {
        return PetResponseDto.builder()
                .id(pet.getId())
                .name(pet.getName())
                .age(pet.getAge())
                .category(pet.getCategory())
                .build();
    }

    public List<PetResponseDto> toListPetResponseDto(List<Pet> petList) {
        return petList.stream().map(this::toPetResponseDto).toList();
    }
}
