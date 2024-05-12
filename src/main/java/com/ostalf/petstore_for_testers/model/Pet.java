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
    @SequenceGenerator(name = "cat_id_seq", sequenceName = "cat_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "cat_id_seq")
    @Column(name = "id", nullable = false)
    Integer id;

    @NotNull
    @Column(unique = true)
    String name;

    @Column(name = "age")
    int age;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
    String categoryName;
}
