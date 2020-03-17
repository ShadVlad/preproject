package model;
import org.hibernate.annotations.*;
//import org.hibernate.annotations.Table;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "users")
@Table(name = "users")
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;

    @Column(name = "name")
    private String name;

    @Column(name = "surName")
    private String surName;

    @Column(name = "age")
    private int age;

    @Column(name = "eMail")
    private String eMail;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private String role;

    public User() {
    }

    public User(int id, String name, String surName, int age, String eMail, String login, String password, String role) {
        super();
        this.id = id;
        this.name = name;
        this.surName = surName;
        this.age = age;
        this.eMail = eMail;
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public User(String name, String surName, int age, String eMail, String login, String password, String role) {
        super();
        this.name = name;
        this.surName = surName;
        this.age = age;
        this.eMail = eMail;
        this.login = login;
        this.password = password;
        this.role = role;
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

    public String getLogin() { return login; }
    public void setLogin(String login) { this.login = login; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

}


