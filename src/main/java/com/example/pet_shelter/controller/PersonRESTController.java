package com.example.pet_shelter.controller;


import com.example.pet_shelter.model.Person;
import com.example.pet_shelter.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class PersonRESTController {

    @Autowired
    private PersonService personService;

    @GetMapping("/persons")
    public List<Person> showAllPersons() {
        List<Person> allPerosns = personService.getAllPersons();
        return allPerosns;
    }

    @GetMapping("/persons/{id}")
    @Cacheable (value = "personID")
    public Optional<Person> getPerson(@PathVariable int id) {
        Optional<Person> person = personService.getPerson(id);
        return person;
    }


    @PostMapping("/persons")
    public Person addNewPerson(@RequestBody Person person) {
        personService.savePerson(person);
        return person;
    }



    @PutMapping("/persons")
    public Person updatePerson(@RequestBody Person person) {
        personService.savePerson(person);
        return person;
    }


    @DeleteMapping("/persons/{id}")
    public String deletePerson(@PathVariable int id) {
        personService.deletePerson(id);
        return "Person with ID = " + id + " was deleted";
    }


}
