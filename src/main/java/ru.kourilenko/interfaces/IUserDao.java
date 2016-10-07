package ru.kourilenko.interfaces;

import ru.kourilenko.entity.User;

import java.util.List;

public interface IUserDao {
    List<User> findAll();

    void create(User user);

    boolean checkExistenceUser(String name);

    User getUserByName(String name);

    void deleteUser(String name);
}
