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
@Table(name = "pet")

public class Pet {
    @Id
    @NotNull
    @SequenceGenerator(name = "pet_id_seq", sequenceName = "pet_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "pet_id_seq")
    @Column(name = "id")
    int id;

    @NotNull
    @Column(unique = true)
    String name;

    @NotNull
    @Column(name = "age")
    int age;

    @ManyToOne(cascade = CascadeType.MERGE)
    Category category;

}
