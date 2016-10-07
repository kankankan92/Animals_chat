package ru.kourilenko.fake_dao;

import ru.kourilenko.entity.User;
import ru.kourilenko.interfaces.IMessageDao;
import ru.kourilenko.interfaces.IUserDao;

import java.util.List;

public class UserDao implements IUserDao {


    @Override
    public List<User> findAll() {
        return Storage.getInstance().users;
    }

    @Override
    public void create(User user) {
        Storage.getInstance().users.add(user);
    }

    @Override
    public boolean checkExistenceUser(String name) {
        return Storage.getInstance().users.stream().anyMatch(usr -> usr.getName().equals(name));
    }

    @Override
    public User getUserByName(String name) {
        for (User user : Storage.getInstance().users) {
            if (user.getName().equals(name)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public void deleteUser(String name) {
        IMessageDao messageDao = new MessageDao();
        messageDao.deleteAllMessagesUser(name);
        Storage.getInstance().users.remove(getUserByName(name));

    }
}
