package com.example.pet_shelter.dao;


import com.example.pet_shelter.entity.Person;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;


@Service
public class PersonDAOImpl implements PersonDAO {

    @Autowired
    private EntityManager entityManager;


    @Override
    public List<Person> getAllPersons() {
        Session session = entityManager.unwrap(Session.class);
        Query<Person> query = session.createQuery("from Person", Person.class);
        List<Person> allPersons = query.getResultList();
        return allPersons;
    }


    @Override
    public void savePerson(Person person) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(person);
    }

    @Override
    public Person getPerson(int id) {
        Session session = entityManager.unwrap(Session.class);

        Person person = session.get(Person.class, id);
        return person;
    }

    @Override
    public void deletePerson(int id) {
        Session session = entityManager.unwrap(Session.class);
        Query <Person> query = session.createQuery("DELETE FROM Person " + "WHERE id =:personID");
        query.setParameter("personID", id);
        query.executeUpdate();
    }

}
