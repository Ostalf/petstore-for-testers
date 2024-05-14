package com.ostalf.petstore_for_testers.mapper;

import com.ostalf.petstore_for_testers.dto.CategoryResponseDto;
import com.ostalf.petstore_for_testers.model.Category;

import java.util.List;

public class CategoryMapper {
    public CategoryResponseDto toCategoryResponseDto(Category category) {
        return CategoryResponseDto.builder().id(category.getId()).name(category.getName()).build();
    }

    public List<CategoryResponseDto> toListPetResponseDto(List<Category> categoryList) {
        return categoryList.stream().map(this::toCategoryResponseDto).toList();
    }
}
