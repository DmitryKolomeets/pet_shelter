package com.example.pet_shelter.service;



import com.example.pet_shelter.model.Animal;
import com.example.pet_shelter.repository.AnimalRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

@Service
public class AnimalServiceImpl implements AnimalService {

    private final AnimalRepository repository;

    public AnimalServiceImpl(AnimalRepository repository) {
        this.repository = repository;
    }


    @Override
    @Transactional
    public List<Animal> getAllAnimals() {return (List <Animal>) repository.findAll(); }


    @Override
    @Transactional
    public  void saveAnimal (Animal animal) {repository.save(animal);}


    @Override
    @Transactional
    public Optional<Animal> getAnimal(int id) {return repository.findById(id);}

    @Override
    @Transactional
    public void deleteAnimal(int id) {repository.deleteById(id);}

}




