package com.project.hackathon.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import java.util.HashSet;
import java.util.Set;


@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Category")
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @NotBlank(message = "{name is invalid}")
    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "categories")
    private Set<PositionEntity> positions = new HashSet<>();
}
