package ru.kourilenko;

abstract public class User {

    String name;

    User(String name){
        this.name = name;
    }

    abstract String getGender();
}
