package ru.kourilenko.entity;

public class Female extends User {
    public Female(String name) {
        super(name);
    }

    @Override
    public String getGender() {
        return "жен";
    }
}
