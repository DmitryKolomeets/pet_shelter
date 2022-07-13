package com.example.pet_shelter.service;


import com.example.pet_shelter.model.Person;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface PersonService {

    public List<Person> getAllPersons();

    public  void savePerson(Person person);

    public Optional<Person> getPerson(int id);

    public void deletePerson(int id);


}
