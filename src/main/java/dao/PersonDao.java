package dao;

import model.Person;
import service.PersonService;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class PersonDao implements IPersonDao {

    private EntityManager entityManager = Persistence.createEntityManagerFactory("PersonDB").createEntityManager();

    @Override
    public List<Person> getAll() {
        TypedQuery<Person> namedQuery = entityManager.createNamedQuery("Person.getAll", Person.class);
        return namedQuery.getResultList();
    }

    @Override
    public boolean add(String name, String surName, String skills) {
        try {
            Person person = new Person();
            person.setName(name);
            person.setName(surName);
            person.setSkills(skills);
            entityManager.getTransaction().begin();
            entityManager.persist(person);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Person getById(int id) {
        return entityManager.find(Person.class, id);
    }

    @Override
    public boolean update(String name, String surName, String skills, int id) {
        entityManager.getTransaction().begin();

        if (getById(id) != null) {
            Person person = getById(id);
            person.setName(name);
            person.setSurName(surName);
            person.setSkills(skills);
            entityManager.merge(person);
            entityManager.getTransaction().commit();
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean delete(int id) {
        if (getById(id) != null) {
            entityManager.getTransaction().begin();
            entityManager.remove(getById(id));
            entityManager.getTransaction().commit();
            return true;
        } else {
            return false;
        }
    }
}