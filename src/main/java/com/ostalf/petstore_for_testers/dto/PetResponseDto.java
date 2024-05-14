package com.ostalf.petstore_for_testers.dto;

import com.ostalf.petstore_for_testers.model.Category;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PetResponseDto {

    Integer id;

    String name;

    int age;

    Category category;

}
