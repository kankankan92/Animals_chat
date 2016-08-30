package ru.kourilenko;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Chat {
    List<Message> messages = new ArrayList<>();
    List<User> users = new ArrayList<>();
    User currentUser;

    public void addUser() {
        System.out.println("Введите имя:");
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String name = scanner.nextLine();
            if (checkExistenceUser(name)) {
                System.out.println("Пользователь с таким именем уже сущестует! Придумайте другое имя:");
            } else {
                User user;
                System.out.println("Выберите ваш пол. Введите м или ж");
                switch (scanner.nextLine()) {
                    case "м":
                        user = new Male(name);
                        users.add(user);
                        break;
                    case "ж":
                        user = new Female(name);
                        users.add(user);
                        break;

                }
                break;
            }
        }
    }

    public void loginUser(String name) {

    }

    public void deleteUser(String name) {

    }

    public boolean checkExistenceUser(String name) {
        for (User user : users) {
            if (user.name.equals(name)) {
                return true;
            }
        }
        return false;
    }

}
