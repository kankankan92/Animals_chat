package ru.kourilenko.entity;

import java.time.LocalDateTime;
import java.util.Random;

public class Message {

    private Integer id;
    private String message;
    private String from;
    private String to;
    private LocalDateTime localDateTime;

    public Message(String message, String from, String to, LocalDateTime localDateTime) {
        this.message = message;
        this.from = from;
        this.to = to;
        this.localDateTime = localDateTime;
        id = new Random().nextInt();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
