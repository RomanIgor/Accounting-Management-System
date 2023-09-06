package com.igor.boot.fullstackApp.entity;


import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;


@Entity
@EntityScan
@Table(name = "Person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "username")
    private String username;
    @Column(name = "year_of_birth")
    private int yearOfBirth;
    @Column(name = "password")
    private String password;
    @Column(name = "role")
    private String role;

    public Person() {
    }

    public Person(Long id, String username, int yearOfBirth, String password) {
        this.id = id;
        this.username = username;
        this.yearOfBirth = yearOfBirth;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", yearOfBirth=" + yearOfBirth +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}

