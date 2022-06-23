package com.example.pet_shelter.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name= "animals")
public class Animal {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;


    @Column(name="name")
    private String name;

    @Column(name="family")
    private String family;

    @Column(name="breed")
    private String breed;

}