package ru.kourilenko;

import java.util.Scanner;

public class Chat {
    public  int a;
    public static void chat(){
        while (true){
            System.out.println("1.Зарегистрироваться, 2.Войти, 3.Удалить пользователя, 4.Выйти из программы.");
            Scanner scan = new Scanner(System.in);
            switch (scan.nextLine()){
                case "1":

                    break;
                case "2":
                    while (true){
                        System.out.println("1.Написать конкретному пользователю\n 2.Написать всем, из своей группы\n 3.Написать всем из чужой группы\n 4.Написать всем\n 5.Прочитать свои сообщения\n 6.Выйти");
                        switch (scan.nextLine()){
                            case "1":

                                break;
                            case "2":

                                break;
                            case "3":

                                break;
                            case  "4":
                                break;
                            case  "5":
                                break;
                            case "6":
                                return;
                            default:
                        }
                    }
                case "3":

                    break;
                case "4":
                    return;
                default:
            }
        }
    }
}
