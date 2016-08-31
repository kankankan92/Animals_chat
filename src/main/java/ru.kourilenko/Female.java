package ru.kourilenko;

public class Female extends User {
    Female(String name) {
        super(name);
    }

    @Override
    String getGender() {
        return "жен";
    }
}
