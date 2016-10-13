package ru.kourilenko;

import ru.kourilenko.entity.Female;
import ru.kourilenko.entity.Male;
import ru.kourilenko.entity.Message;
import ru.kourilenko.entity.User;
import ru.kourilenko.fake_dao.MessageDao;
import ru.kourilenko.dao.UserDao;
import ru.kourilenko.interfaces.IMessageDao;
import ru.kourilenko.interfaces.IUserDao;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Chat {
    private User currentUser;
    private IUserDao userDao = new UserDao();
    private IMessageDao messageDao = new MessageDao();

    public void writeSpecificBrow() { //Написать конкретному челу
        System.out.println("Введите имя пользователя, которому хотите отправить письмо:");
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String name = scanner.nextLine();
            if (userDao.checkExistenceUser(name)) {
                System.out.println("Введите сообщения для пользователя " + name + ":");
                Message message = new Message(scanner.nextLine(), currentUser.getName(), name, LocalDateTime.now());
                messageDao.create(message);
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
        for (User user : userDao.findAll()) {
            if (user.getGender().equals(currentUser.getGender())&&!user.getName().equals(currentUser.getName())) {
                Message message = new Message(textMessage, currentUser.getName(), user.getName(), LocalDateTime.now());
                messageDao.create(message);
            }
        }
    }

    public void writeOtherGroup() {
        System.out.println("Введите сообщение, которое вы хотите отправить всем пользователям противоположного пола в данном чате:");
        Scanner scanner = new Scanner(System.in);
        String textMessage = scanner.nextLine();
        for (User user : userDao.findAll()) {
            if (!user.getGender().equals(currentUser.getGender())) {
                Message message = new Message(textMessage, currentUser.getName(), user.getName(), LocalDateTime.now());
                messageDao.create(message);
            }
        }
    }

    public  void writeAllUsers(){
        System.out.println("Введите сообщение, которое вы хотите отправить всем пользователям в данном чате:");
        Scanner scanner = new Scanner(System.in);
        String textMessage = scanner.nextLine();
        for (User user : userDao.findAll()) {
                Message message = new Message(textMessage, currentUser.getName(), user.getName(), LocalDateTime.now());
            messageDao.create(message);
        }
    }

    public void readMessages() {
        boolean flag = false;
        for (Message message : messageDao.findAll()) {
            if (message.getTo().equals(currentUser.getName())) {
                flag = true;
                System.out.println("_________________________________\n" +
                        message.getFrom() + "     " + message.getLocalDateTime().format(DateTimeFormatter.ofPattern("dd LLL yyyy, HH:mm")) + "\n" +
                        message.getMessage() + "\n");
            }
        }
        if (!flag) System.out.println("К сожалению для вас нет сообщений. :( \n");
    }

    public void addUser() {
        System.out.println("Введите имя:");
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String name = scanner.nextLine();
            if (userDao.checkExistenceUser(name)) {
                System.out.println("Пользователь с таким именем уже сущестует! Придумайте другое имя:");
            } else {
                User user;
                innerWhileLable:
                while (true) {
                    System.out.println("Выберите ваш пол. Введите м или ж");
                    switch (scanner.nextLine()) {
                        case "м":
                            user = new Male(name);
                            userDao.create(user);
                            break innerWhileLable;
                        case "ж":
                            user = new Female(name);
                            userDao.create(user);
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
        for (User user : userDao.findAll()) {
            System.out.println(user.getName() + "(" + user.getGender() + ")");
        }
    }

    public void loginUser() {
        System.out.println("Введите имя пользователя:");
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String name = scanner.nextLine();
            if (userDao.checkExistenceUser(name)) {
                currentUser = userDao.getUserByName(name);
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
        System.out.println("Введите имя пользователя, которого хотите удалить:");
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String name = scanner.nextLine();
            if (userDao.checkExistenceUser(name)) {
                while (true) {
                    System.out.println("Вы уверенны, что хотите его удалить? Да/Нет");
                    switch (scanner.nextLine()) {
                        case "Да":
                            userDao.deleteUser(name);
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
}
