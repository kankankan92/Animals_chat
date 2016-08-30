package ru.kourilenko;

import java.time.LocalDateTime;

public class Message {
    public String message;
    public String from;
    public String to;
    public LocalDateTime localDateTime;

    public Message(String message, String from, String to, LocalDateTime localDateTime) {
        this.message = message;
        this.from = from;
        this.to = to;
        this.localDateTime = localDateTime;
    }

    @Override
    public String toString() {
        return "Message{" +
                "localDateTime=" + localDateTime +
                ", to='" + to + '\'' +
                ", from='" + from + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
