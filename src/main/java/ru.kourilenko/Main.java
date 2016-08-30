package ru.kourilenko;

public class Main {
    public static void main(String[] args) {
        Chat chat = new Chat();
        chat.addUser();
        chat.addUser();
        System.out.println(chat.users.get(0).name);


    }
}
