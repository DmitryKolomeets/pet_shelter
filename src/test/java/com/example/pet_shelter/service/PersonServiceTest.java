package com.example.pet_shelter.service;

import com.example.pet_shelter.model.Person;
import com.example.pet_shelter.repository.PersonRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;




public class PersonServiceTest {

    private final PersonRepository personRepository = Mockito.mock(PersonRepository.class);
    private final PersonServiceImpl personService = new PersonServiceImpl(this.personRepository);

    @Test
    public void savePersonTest() {
        Person person = Person.builder().id(10).name("Hector").build();

        Mockito
                .when(this.personRepository.save(Mockito.any()))
                .thenReturn(person);


        Assertions.assertEquals(person, this.personService.savePerson(person));
        Mockito.verify(this.personRepository).save(person);
    }

    @Test
    public void getPersonTest() {
        Person person = Person.builder().id(10).name("Hector").build();

        Mockito
                .when(this.personRepository.findById(Mockito.anyInt()))
                .thenReturn(Optional.of(person));

        Assertions.assertNotEquals(person, this.personService.getPerson(Mockito.anyInt()));
        Mockito.verify(this.personRepository).findById(Mockito.anyInt());
    }


    @Test
    public void deletePersonTest() {
        Person person = Person.builder().id(321).name("Peter").build();

        this.personService.deletePerson(person.getId());

        Mockito.verify(this.personRepository).deleteById(Mockito.anyInt());
    }



    @Test
    public void getPersonesTest() {

        Person person1 = Person.builder().id(1).age(25).name("Peter").surname("Kovalski").sex('m').build();
        Person person2 = Person.builder().id(2).age(40).name("Klaus").surname("Santa").sex('m').build();

        List<Person> persons = new ArrayList<>();
        persons.add(person1);
        persons.add(person2);

        Mockito.when(personRepository.findAll()).thenReturn(persons);

       Assertions.assertTrue((personService.getAllPersons().size()) > 0);
    }

}
