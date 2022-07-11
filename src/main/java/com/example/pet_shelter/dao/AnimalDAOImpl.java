package com.example.pet_shelter.dao;


import com.example.pet_shelter.entity.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.hibernate.Session;
import org.hibernate.query.Query;


import javax.persistence.EntityManager;
import java.util.List;


@Service
public class AnimalDAOImpl implements AnimalDAO {

    @Autowired
    private EntityManager entityManager;


    @Override
    public List<Animal> getAllAnimals() {
        Session session = entityManager.unwrap(Session.class);
        Query<Animal> query = session.createQuery("from Animal", Animal.class);
        List<Animal> allAnimals = query.getResultList();
       return allAnimals;
    }


    @Override
    public void saveAnimal(Animal animal) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(animal);
    }

    @Override
    public Animal getAnimal(int id) {
        Session session = entityManager.unwrap(Session.class);

        Animal animal = session.get(Animal.class, id);
        return animal;
    }

    @Override
    public void deleteAnimal(int id) {
        Session session = entityManager.unwrap(Session.class);
        Query <Animal> query = session.createQuery("DELETE FROM Animal " + "WHERE id =:animalID");
        query.setParameter("animalID", id);
        query.executeUpdate();
    }

}
