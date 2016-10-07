package ru.kourilenko.fake_dao;

import ru.kourilenko.entity.Message;
import ru.kourilenko.entity.User;

import java.util.ArrayList;
import java.util.List;

public class Storage {
    private Storage(){}

    private static Storage storage = new Storage();

    public static Storage getInstance(){
        return storage;
    }

    public List<Message> messages = new ArrayList<>();
    public List<User> users = new ArrayList<>();
}
