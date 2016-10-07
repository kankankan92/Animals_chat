package ru.kourilenko;

import java.sql.*;

public class JdbcHelper {

    public static Connection getConnection(){
        try {
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/learnjdbc", "postgres", "postgres");
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ResultSet getResult(String query){
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = getConnection().createStatement();
            rs = stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Проблема с БД");
        }
        return rs;
    }

    public static void runQuery(String query){
        Statement stmt = null;
        try {
            stmt = getConnection().createStatement();
            stmt.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Проблема с БД");
        }
    }
}
