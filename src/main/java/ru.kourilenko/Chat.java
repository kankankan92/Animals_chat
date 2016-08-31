package ru.kourilenko;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Chat {
    List<Message> messages = new ArrayList<>();
    List<User> users = new ArrayList<>();
    User currentUser;

    public void writeSpecificBrow() { //Написать конкретному челу
        System.out.println("Введите имя пользователя, которому хотите отправить письмо:");
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String name = scanner.nextLine();
            if (checkExistenceUser(name)) {
                System.out.println("Введите сообщения для пользователя " + name + ":");
                Message message = new Message(scanner.nextLine(), currentUser.name, name, LocalDateTime.now());
                messages.add(message);
                break;
            } else {
                System.out.println("Пользователя с таким именем не существует. Попробуйте еще раз:");
            }
        }
    }

    public void writeMyGroup() {
        System.out.println("Введите сообщение, которое вы хотите отправить всем пользователям вашего пола в данном чате:");
        Scanner scanner = new Scanner(System.in);
        String textMessage = scanner.nextLine();
        for (User user : users) {
            if (user.getGender().equals(currentUser.getGender())&&!user.name.equals(currentUser.name)) {
                Message message = new Message(textMessage, currentUser.name, user.name, LocalDateTime.now());
                messages.add(message);
            }
        }
    }

    public void writeOtherGroup() {
        System.out.println("Введите сообщение, которое вы хотите отправить всем пользователям противоположного пола в данном чате:");
        Scanner scanner = new Scanner(System.in);
        String textMessage = scanner.nextLine();
        for (User user : users) {
            if (!user.getGender().equals(currentUser.getGender())) {
                Message message = new Message(textMessage, currentUser.name, user.name, LocalDateTime.now());
                messages.add(message);
            }
        }
    }

    public  void writeAllUsers(){
        System.out.println("Введите сообщение, которое вы хотите отправить всем пользователям в данном чате:");
        Scanner scanner = new Scanner(System.in);
        String textMessage = scanner.nextLine();
        for (User user : users) {
                Message message = new Message(textMessage, currentUser.name, user.name, LocalDateTime.now());
                messages.add(message);
        }
    }

    public void readMessages() {
        //TODO Тут какая-то херня с флагами! Надо переделать
        boolean flag = false;
        for (Message message : messages) {
            if (message.to.equals(currentUser.name)) {
                flag = false;
                System.out.println("_________________________________\n" +
                        message.from + "     " + message.localDateTime.format(DateTimeFormatter.ofPattern("dd LLL yyyy, HH:mm")) + "\n" +
                        message.message + "\n");
            } else {
                flag = true;
            }
        }
        if (flag) System.out.println("К сожалению для вас нет сообщений. :( \n");

    }

    public void addUser() {
        System.out.println("Введите имя:");
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String name = scanner.nextLine();
            if (checkExistenceUser(name)) {
                System.out.println("Пользователь с таким именем уже сущестует! Придумайте другое имя:");
            } else {
                User user;
                innerWhileLable:
                while (true) {
                    System.out.println("Выберите ваш пол. Введите м или ж");
                    switch (scanner.nextLine()) {
                        case "м":
                            user = new Male(name);
                            users.add(user);
                            break innerWhileLable;
                        case "ж":
                            user = new Female(name);
                            users.add(user);
                            break innerWhileLable;
                        default:
                            System.out.println("Неверно указан пол.");
                    }
                }
                break;
            }
        }
    }

    public void printAllUser() {
        for (User user : users) {
            System.out.println(user.name + "(" + user.getGender() + ")");
        }
    }

    public void loginUser() {
        System.out.println("Введите имя пользователя:");
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String name = scanner.nextLine();
            if (checkExistenceUser(name)) {
                currentUser = getUserByName(name);
                break;
            } else {
                System.out.println("Пользователя с таким именем не существует! Попробуйте еще раз:");
            }
        }
    }

    public void logOutUser() {
        currentUser = null;
    }

    public void deleteUser() {
        //TODO сделать очистку сообщений удаленного прльзователя из массива
        System.out.println("Введите имя пользователя, которого хотите удалить:");
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String name = scanner.nextLine();
            if (checkExistenceUser(name)) {
                while (true) {
                    System.out.println("Вы уверенны, что хотите его удалить? Да/Нет");
                    switch (scanner.nextLine()) {
                        case "Да":
                            users.remove(getUserByName(name));
                            return;
                        case "Нет":
                            return;
                        default:
                    }
                }
            } else {
                System.out.println("Пользователя с таким именем не существует! Попробуйте еще раз:");
            }
        }

    }

    public User getUserByName(String name) {
        for (User user : users) {
            if (user.name.equals(name)) {
                return user;
            }
        }
        return null; //TODO добавить ошибку "Пользователя с данным именем не существует"
    }

    public boolean checkExistenceUser(String name) {
        //TODO использовать новую штуку с потоком
        for (User user : users) {
            if (user.name.equals(name)) {
                return true;
            }
        }
        return false;
    }

}
