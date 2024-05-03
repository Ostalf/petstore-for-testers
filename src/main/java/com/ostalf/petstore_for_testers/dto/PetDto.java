package com.ostalf.petstore_for_testers.dto;

import lombok.AccessLevel;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString

public class PetDto {
    String name;
    int age;
}
