package ru.javamentor.model;
import java.sql.Array;
import java.util.concurrent.atomic.AtomicInteger;

//@Entity
//@Table(name = "cars")
public class User {

//    @Id
//    @Column(name = "id")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;

//    @Column(name = "name")
    private String name;

//    @Column(name = "surName")
    private String surName;

//    @Column(name = "eMail")
    private String eMail;

//    @Column(name = "age")
    private int age;

    public User() {
    }

    public User(int id, String name, String surName, int age, String eMail) {
        super();
        this.id = id;
        this.name = name;
        this.surName = surName;
        this.age = age;
        this.eMail = eMail;
    }
    public User(String name, String surName, int age, String eMail) {
        super();
        this.name = name;
        this.surName = surName;
        this.age = age;
        this.eMail = eMail;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surName;
    }
    public void setSurname(String surName) {
        this.surName = surName;
    }

    public String getEmail() {
        return eMail;
    }
    public void setEmail(String eMail) {
        this.eMail = eMail;
    }

}


