package com.example.pet_shelter.service;


import com.example.pet_shelter.entity.Person;
import org.springframework.stereotype.Repository;

import java.util.List;



@Repository
public interface PersonService {

    public List<Person> getAllPersons();

    public  void savePerson(Person person);

    public Person getPerson(int id);

    public void deletePerson(int id);


}
