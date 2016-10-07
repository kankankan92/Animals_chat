package ru.kourilenko.fake_dao;

import ru.kourilenko.entity.Message;
import ru.kourilenko.interfaces.IMessageDao;

import java.util.List;
import java.util.stream.Collectors;

public class MessageDao implements IMessageDao {

    @Override
    public void create(Message message) {
        Storage.getInstance().messages.add(message);
    }

    @Override
    public List<Message> findAll() {
        return Storage.getInstance().messages;
    }

    public void deleteAllMessagesUser(String name){
        Storage.getInstance().messages.removeAll(Storage.getInstance().messages.stream().filter(msg -> msg.getTo().equals(name)).collect(Collectors.toList()));
    }
}
