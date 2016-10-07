package ru.kourilenko.entity;

import java.util.Random;

abstract public class User {

    private Integer id;
    private String name;

    public User(String name){
        this.name = name;
        id = new Random().nextInt();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    abstract public String getGender();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
