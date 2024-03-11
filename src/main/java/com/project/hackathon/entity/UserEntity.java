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
    private Long Id;

    @Column
    private String Login;

    @Column
    private String Password;

    @Column
    private String FirstName;

    @Column
    private String LastName;

    @Column
    private Boolean Gender;

    @Column
    private LocalDate BDday;

    @Column
    private String Email;

    @Column
    private String Phone;

    @JoinColumn
    @ManyToOne
    private UniversityEntity universityID;
}
