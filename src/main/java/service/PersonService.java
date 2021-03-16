package service;

import dao.IPersonDao;
import model.Person;

import javax.inject.Inject;
import java.util.List;

public class PersonService implements IPersonService {

    @Inject
    private IPersonDao personDao;

    @Override
    public List<Person> getAll() {
        return personDao.getAll();
    }

    @Override
    public boolean add(String name, String surName, String skills) {
        return personDao.add(name,surName,skills);
    }

    @Override
    public Person getById(int id) {

        return personDao.getById(id);
    }

    @Override
    public boolean update(String name, String surName, String skills ,int id) {
        return  personDao.update(name,surName,skills, id);
    }

    @Override
    public boolean delete(int id) {
        return personDao.delete(id);
    }
}