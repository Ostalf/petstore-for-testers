package com.ostalf.petstore_for_testers.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class PetRequestDto {

    String name;

    int age;

    int categoryId;

}
