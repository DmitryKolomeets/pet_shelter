package com.example.pet_shelter.service;

import com.example.pet_shelter.model.Animal;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface AnimalService {

    public List<Animal> getAllAnimals();

    public  void saveAnimal(Animal animal);

    public Optional<Animal> getAnimal(int id);

    public void deleteAnimal(int id);


}
