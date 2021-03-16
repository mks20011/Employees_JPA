package dao;

import model.Person;

import java.util.List;

public interface IPersonDao {

    public List<Person> getAll();

    public boolean add(String name, String surName, String skills);

    public Person getById(int id);

    public boolean update(String name, String surName, String skills ,int id);

    public boolean delete(int id);
}