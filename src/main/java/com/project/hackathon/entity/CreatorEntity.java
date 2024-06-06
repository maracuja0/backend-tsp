package com.project.hackathon.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Creator")
public class CreatorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @NotBlank(message="{password is invalid}")
    @Column(name = "password")
    private String password;

    @Column(name = "first_name")
    @Size(min = 1, max = 30, message = "{size is invalid}")
    private String firstName;

    @Column(name = "last_name")
    @Size(min = 1, max = 30, message = "{size is invalid}")
    private String lastName;

    @Column(name = "company")
    @Size(min = 3, max = 30, message = "{size is invalid}")
    private String company;

    @Column(name = "gender")
    private Boolean gender;

    @NotNull(message="{birthday is invalid}")
    @Column(name = "bday")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Past
    private LocalDate bday;

    @NotBlank(message="{phone is invalid}")
    @Column(name = "phone", length = 11,  unique = true)
    private String phone;

    @Column(name = "email", unique = true)
    private String email;
}
