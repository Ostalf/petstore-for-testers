package com.ostalf.petstore_for_testers.dto;

import com.ostalf.petstore_for_testers.model.Category;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class PetResponseDto {

    Integer id;

    String name;

    int age;

    Category category;

}
