package com.example.pet_shelter.service;

import com.example.pet_shelter.model.Animal;
import com.example.pet_shelter.repository.AnimalRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class AnimalServiceTest {

    private final AnimalRepository animalRepository = Mockito.mock(AnimalRepository.class);
    private final AnimalServiceImpl animalService = new AnimalServiceImpl(this.animalRepository);

    @Test
    public void saveAnimalTest() {
        Animal animal = Animal.builder().id(5).name("Hector").build();

        Mockito
                .when(this.animalRepository.save(Mockito.any()))
                .thenReturn(animal);


        Assertions.assertEquals(animal, this.animalService.saveAnimal(animal));
        Mockito.verify(this.animalRepository).save(animal);
    }

    @Test
    public void getAnimalTest() {
        Animal animal = Animal.builder().id(10).name("Hector").build();

        Mockito
                .when(this.animalRepository.findById(Mockito.anyInt()))
                .thenReturn(Optional.of(animal));

        Assertions.assertNotEquals(animal, this.animalService.getAnimal(Mockito.anyInt()));
        Mockito.verify(this.animalRepository).findById(Mockito.anyInt());
    }


    @Test
    public void deleteAnimalTest() {
        Animal animal = Animal.builder().id(15).name("Barsik").build();

        this.animalService.deleteAnimal(animal.getId());

        Mockito.verify(this.animalRepository).deleteById(Mockito.anyInt());
    }



    @Test
    public void getAnimalsTest() {

        Animal animal1 = Animal.builder().id(1).name("Blacky").breed("Cat").build();
        Animal animal2 = Animal.builder().id(2).name("Whity").breed("Cat").build();

        List<Animal> animals = new ArrayList<>();
        animals.add(animal1);
        animals.add(animal2);

        Mockito.when(animalRepository.findAll()).thenReturn(animals);

        Assertions.assertTrue((animalService.getAllAnimals().size()) > 0);
    }

}
