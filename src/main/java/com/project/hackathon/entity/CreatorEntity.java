package com.project.hackathon.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Creator")
public class CreatorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String login;

    @Column
    private String password;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private LocalDate bDay;

    @Column
    private String phone;

    @Column
    private String email;
}
