package com.example.pet_shelter.dao;

import com.example.pet_shelter.entity.Animal;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalDAO {

    public List<Animal> getAllAnimals();

    public void saveAnimal(Animal animal);

    public Animal getAnimal(int id);

    public void deleteAnimal(int id);

}
