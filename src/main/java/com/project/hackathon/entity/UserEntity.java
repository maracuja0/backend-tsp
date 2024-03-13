package com.project.hackathon.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

//@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Users")
public class UserEntity {
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
    private Boolean gender;

    @Column
    private LocalDate bDay;

    @Column
    private String email;

    @Column
    private String phone;

    @JoinColumn
    @ManyToOne
    private UniversityEntity universityID;
}
