package ru.kourilenko.interfaces;

import ru.kourilenko.entity.Message;

        import java.util.List;

public interface IMessageDao {
    void create(Message message);

    List<Message> findAll();

    void deleteAllMessagesUser(String name);
}
