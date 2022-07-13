package com.example.pet_shelter.repository;

import com.example.pet_shelter.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository <Person, Integer> {
}
