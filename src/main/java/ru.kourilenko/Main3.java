package ru.kourilenko;

import java.sql.*;

public class Main3 {
    public static void main(String[] args) {
        String query = "select * from users";

        try (
                Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/learnjdbc", "postgres", "postgres");
                Statement stmt = connection.createStatement()
        ) {
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                System.out.println("Id : " + id + ", name: " + name);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
