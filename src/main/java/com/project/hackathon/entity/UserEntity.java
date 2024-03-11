package com.project.hackathon.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

//@Data
@Entity
@Table(name="Users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    private Boolean GenderName;

    @Column
    private LocalDate BDday;

    @Column
    private String Email;

    @Column
    private String Phone;

    public UserEntity(Long id, String login, String password) {
        Id = id;
        Login = login;
        Password = password;
    }

    public UserEntity(){

    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getLogin() {
        return Login;
    }

    public void setLogin(String login) {
        Login = login;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public Boolean getGenderName() {
        return GenderName;
    }

    public void setGenderName(Boolean genderName) {
        GenderName = genderName;
    }

    public LocalDate getBDday() {
        return BDday;
    }

    public void setBDday(LocalDate BDday) {
        this.BDday = BDday;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }
}
