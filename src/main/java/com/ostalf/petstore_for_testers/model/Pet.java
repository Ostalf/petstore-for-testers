package com.ostalf.petstore_for_testers.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
@Setter
@Entity
@Table(name = "pet")
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    private String name;

}
