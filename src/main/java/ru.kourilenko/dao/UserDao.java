package ru.kourilenko.dao;

import ru.kourilenko.JdbcHelper;
import ru.kourilenko.entity.Female;
import ru.kourilenko.entity.Male;
import ru.kourilenko.entity.User;
import ru.kourilenko.interfaces.IUserDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserDao implements IUserDao {

    @Override
    public void create(User user) {
        String query = "insert into users (id, name, gender) values (:id, ':name', ':gender');"
//        String query = "insert into users (id, name, gender) values (" + user.getId() + ", " + user.getName() + ", " + user.getGender() + ");";
                .replace(":id", user.getId().toString())
                .replace(":name", user.getName())
                .replace(":gender", user instanceof Male ? "m" : "f");
        JdbcHelper.runQuery(query);
    }

    @Override
    public boolean checkExistenceUser(String name) {
        String query = "select count(*) from users where name = '" + name + "';";
        ResultSet rs = JdbcHelper.getResult(query);
        boolean check = false;
        try {
            rs.next();
            check = rs.getInt(1) == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
    }

    @Override
    public User getUserByName(String name) {
        String query = "select * from users where name = '" + name + "';";
        ResultSet rs = JdbcHelper.getResult(query);
        User user = null;
        try {
            while (rs.next()) {
                if (rs.getString("gender").equals("m")) {
                    user = new Male(rs.getString("name"));
                } else {
                    user = new Female(rs.getString("name"));
                }
                user.setId(rs.getInt("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public void deleteUser(String name) {
        String query = "delete from users where name = '" + name + "';";
        JdbcHelper.runQuery(query);
    }

    @Override
    public List<User> findAll() {
        String query = "select * from users;";
        ResultSet rs = JdbcHelper.getResult(query);
        List<User> userList = new ArrayList<>();
        try {
            while (rs.next()) {
                User user = null;
                if (rs.getString("gender").equals("m")) {
                    user = new Male(rs.getString("name"));
                } else {
                    user = new Female(rs.getString("name"));
                }
                user.setId(rs.getInt("id"));
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }
}
