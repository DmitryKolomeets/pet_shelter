package com.example.pet_shelter.dao;


import com.example.pet_shelter.entity.Person;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonDAO {

    public List<Person> getAllPersons();

    public void savePerson(Person person);

    public Person getPerson(int id);

    public void deletePerson(int id);

}
