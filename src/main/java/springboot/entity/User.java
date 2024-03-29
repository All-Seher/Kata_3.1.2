package springboot.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "users")
public class User {
  @Id
  @Column
  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String name;

    @Column(name = "surname")
    private String surName;

    public User() {
    }

    public User(String name, String surName) {
        this.name = name;
        this.surName = surName;
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

    @Override
    public String toString() {
        return "Id: " + id +
                ", Name: '" + name + '\'' +
                ", Surname: '" + surName + '\'';
    }
}