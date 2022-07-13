package com.example.pet_shelter.service;


import com.example.pet_shelter.model.Person;
import com.example.pet_shelter.repository.PersonRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

//    @Autowired
//    private PersonDAO personDAO;

    private final PersonRepository repository;

    public PersonServiceImpl(PersonRepository repository) {
        this.repository = repository;
    }


    @Override
    @Transactional
//    public List<Person> getAllPersons() {return personDAO.getAllPersons();}
    public List<Person> getAllPersons() {return (List <Person>) repository.findAll(); }


    @Override
    @Transactional
//    public  void savePerson(Person person) {personDAO.savePerson(person);}
    public  void savePerson (Person person) {repository.save(person);}

    @Override
    @Transactional
//    public Person getPerson(int id) {return personDAO.getPerson(id);}
    public Optional<Person> getPerson(int id) {return repository.findById(id);}


    @Override
    @Transactional
//    public void deletePerson(int id) { personDAO.deletePerson(id);}
    public void deletePerson(int id) {repository.deleteById(id);}

}
