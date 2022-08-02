package com.example.pet_shelter.controller;


import com.example.pet_shelter.model.Animal;
import com.example.pet_shelter.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class AnimalRESTController {

    @Autowired
    private AnimalService animalService;

    @GetMapping("/animals")
    public List<Animal> showAllEmployees() {
        List<Animal> allAnimals = animalService.getAllAnimals();
        return allAnimals;
    }

    @GetMapping("/animals/{id}")
    @Cacheable(value = "AnimalID")
    public Optional<Animal> getAnimal(@PathVariable int id) {
        Optional<Animal> employee = animalService.getAnimal(id);
        return employee;
    }



    @PostMapping("/animals")
    public Animal addNewAnimal(@RequestBody Animal animal) {
        animalService.saveAnimal(animal);
        return animal;
    }


    @PutMapping("/animals")
    public Animal updateAnimal(@RequestBody Animal animal) {
        animalService.saveAnimal(animal);
        return animal;
    }


    @DeleteMapping("/animals/{id}")
    public String deleteAnimal(@PathVariable int id) {
        animalService.deleteAnimal(id);
        return "Animal with ID = " + id + " was deleted";
    }


}
