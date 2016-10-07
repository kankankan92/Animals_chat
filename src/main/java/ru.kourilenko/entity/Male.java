package ru.kourilenko.entity;

public class Male extends User {
    public Male(String name) {
        super(name);
    }

    @Override
    public String getGender() {
        return "муж";
    }
}
