package ru.kourilenko;

import java.util.Scanner;

public class Dialog {
    public static void dialog() {
        Chat chat = new Chat();
        while (true) {
            System.out.println("1.Зарегистрироваться, 2.Войти, 3.Удалить пользователя, 4.Вывести список всех пользователей, 5.Выйти из программы.");
            Scanner scan = new Scanner(System.in);
            switch (scan.nextLine()) {
                case "1":
                    chat.addUser();
                    break;
                case "2":
                    chat.loginUser();
                    lable:
                    while (true) {
                        System.out.println("1.Написать конкретному пользователю\n2.Написать всем из своей группы\n3.Написать всем из чужой группы\n4.Написать всем\n5.Прочитать свои сообщения\n6.Выйти");
                        switch (scan.nextLine()) {
                            case "1":
                                chat.writeSpecificBrow();
                                break;
                            case "2":
                                chat.writeMyGroup();
                                break;
                            case "3":
                                 chat.writeOtherGroup();
                                break;
                            case "4":
                                chat.writeAllUsers();
                                break;
                            case "5":
                                chat.readMessages();
                                break;
                            case "6":
                                chat.logOutUser();
                                break lable;
                            default:
                        }
                    }
                    break;
                case "3":
                    chat.deleteUser();
                    break;
                case "4":
                    chat.printAllUser();
                    break;
                case "5":
                    return;
                default:
            }
        }
    }
}
