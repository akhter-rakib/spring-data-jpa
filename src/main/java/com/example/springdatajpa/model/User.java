package com.example.springdatajpa.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String profession;
    private int age;

    public static User userDataPrepare(String name, String profession, int age) {
        return User.builder().name(name).profession(profession).age(age).build();
    }
}
