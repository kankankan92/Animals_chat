package ru.kourilenko;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main2 {
    public static void main(String[] args) {
        List<Message> list = new ArrayList<>();
        list.add(new Message("Hello", "Vova", "Nastya", LocalDateTime.now()));
        list.add(new Message("Hello 2", "Nastya", "Vova", LocalDateTime.now()));
        list.add(new Message("Hello 3", "Vova", "Rolik", LocalDateTime.now()));
        list.add(new Message("Hello 4", "Rolik", "Vika", LocalDateTime.now()));

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).from.equals("Rolik")) {
                System.out.println(list.get(i));
            }
        }

        for (Message message : list) {
            if(message.from.equals("Rolik")){
                System.out.println(message);
            }
        }

        list
                .stream()
                .filter(msg -> msg.from.equals("Rolik"))
                .forEach(msg -> System.out.println(msg));

        List<Message> nastyaMsgList = list
                .stream()
                .filter(msg -> msg.from.equals("Nastya") || msg.to.equals("Nastya"))
                .collect(Collectors.toList());

        list.stream().anyMatch(msg -> msg.from.equals("Vika"));

        List<String> fromList = list.stream().map(msg -> "From: " + msg.from).collect(Collectors.toList());

        list.stream().forEach(msg -> msg.from = "From:" + msg.from);
        System.out.println(list);

        List<Integer> lettersCountList = list.stream().map(msg -> msg.message.length()).collect(Collectors.toList());

        System.out.println(fromList);

    }
}
