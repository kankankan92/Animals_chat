package ru.kourilenko.dao;

import ru.kourilenko.JdbcHelper;
import ru.kourilenko.entity.Female;
import ru.kourilenko.entity.Male;
import ru.kourilenko.entity.Message;
import ru.kourilenko.entity.User;
import ru.kourilenko.interfaces.IMessageDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MessageDao implements IMessageDao {

    @Override
    public void create(Message message) {
        String query = "insert into messages (id, from_name, to_name, message, date) values (:id, ':from', ':to', ':message', ':data');"
//        String query = "insert into users (id, name, gender) values (" + user.getId() + ", " + user.getName() + ", " + user.getGender() + ");";
                .replace(":id", message.getId().toString())
                .replace(":from", message.getFrom())
                .replace(":to", message.getTo())
                .replace(":message", message.getMessage())
                .replace(":data", message.getLocalDateTime().toString());
        JdbcHelper.runQuery(query);
    }

    @Override
    public List<Message> findAll() {
        String query = "select * from messages";
        ResultSet rs = JdbcHelper.getResult(query);
        List<Message> messagesList = new ArrayList<>();
        try {
            while (rs.next()) {
                Message message = null;
                message = new Message(rs.getString("message"), rs.getString("from_name"), rs.getString("to_name"), LocalDateTime.parse(rs.getString("date")));
                message.setId(rs.getInt("id"));
                messagesList.add(message);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return messagesList;
    }

    @Override
    public void deleteAllMessagesUser(String name) {
        String query = "delete from messages where to_name = '" + name + "';";
        JdbcHelper.runQuery(query);
    }
}
