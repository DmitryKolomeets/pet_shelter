package com.example.pet_shelter.service;


import com.example.pet_shelter.dao.AnimalDAO;
import com.example.pet_shelter.entity.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class AnimalServiceImpl implements AnimalService {

    @Autowired
    private AnimalDAO animalDAO;

    @Override
    @Transactional
    public List<Animal> getAllAnimals() {
        return animalDAO.getAllAnimals();
    }

    @Override
    @Transactional
    public  void saveAnimal(Animal animal) {
        animalDAO.saveAnimal(animal);
    }

    @Override
    @Transactional
    public Animal getAnimal(int id) {
        return animalDAO.getAnimal(id);
    }

    @Override
    @Transactional
    public void deleteAnimal(int id) {
        animalDAO.deleteAnimal(id);
    }

}
