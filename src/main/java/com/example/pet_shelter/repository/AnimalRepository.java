package com.example.pet_shelter.repository;


import com.example.pet_shelter.model.Animal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepository extends CrudRepository<Animal, Integer>{
}


