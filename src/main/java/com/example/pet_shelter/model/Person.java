package com.example.pet_shelter.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name= "persons")
public class Person {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;


    @Column(name="name")
    private String name;

    @Column(name="surname")
    private String surname;


    @Column(name="age")
    private  int age;

    @Column(name="sex")
    private char sex;

}
