package com.example.pet_shelter.controller;


import com.example.pet_shelter.entity.Person;
import com.example.pet_shelter.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PersonRESTController {

    @Autowired
    private PersonService personService;

    @GetMapping("/persons")
    @Cacheable(value = "ShowingAllPersons")
    public List<Person> showAllPersons() {
        List<Person> allPerosns = personService.getAllPersons();
        return allPerosns;
    }

    @GetMapping("/persons/{id}")
    @Cacheable (value = "personID")
    public Person getPerson(@PathVariable int id) {
        Person person = personService.getPerson(id);
        return person;
    }


    @PostMapping("/persons")
    @Cacheable (value = "personNameAdded")
    public Person addNewPerson(@RequestBody Person person) {
        personService.savePerson(person);
        return person;
    }


    @PutMapping("/persons")
    @Cacheable (value = "personNameUpdated")
    public Person updatePerson(@RequestBody Person person) {
        personService.savePerson(person);
        return person;
    }


    @DeleteMapping("/persons/{id}")
    @Cacheable (value = "personNameDeleted")
    public String deletePerson(@PathVariable int id) {
        personService.deletePerson(id);
        return "Person with ID = " + id + " was deleted";
    }


}
