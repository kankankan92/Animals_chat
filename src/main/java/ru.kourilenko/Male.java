package ru.kourilenko;

public class Male extends User {
    Male(String name) {
        super(name);
    }

    @Override
    String getGender() {
        return "муж";
    }
}
