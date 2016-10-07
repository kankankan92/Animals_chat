package ru.kourilenko.dao;

import ru.kourilenko.entity.Message;
import ru.kourilenko.interfaces.IMessageDao;

import java.util.List;

public class MessageDao implements IMessageDao {

    @Override
    public void create(Message message) {

    }

    @Override
    public List<Message> findAll() {
        return null;
    }

    @Override
    public void deleteAllMessagesUser(String name) {

    }
}
