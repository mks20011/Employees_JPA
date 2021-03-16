package model;

import javax.persistence.*;

@Entity
@Table(name = "person")
@NamedQuery(name = "Person.getAll", query = "SELECT p from Person p")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "name", length = 32)
    private String name;
    @Column(name = "surName", length = 32)
    private String surName;
    @Column(name = "skills", length = 32)
    private String skills;

    public Person() {
    }

    public Person(String name, String surName, String skills) {
        this.name = name;
        this.surName = surName;
        this.skills = skills;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }


}
