package com.ostalf.petstore_for_testers.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
@Table(name = "category")

public class Category {
    @Id
    @SequenceGenerator(name = "category_id_seq", sequenceName = "category_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "category_id_seq")
    int id;

    @NotNull
    @Column(unique = true)
    String name;
}
