package com.greenfoxacademy.p2pchat.Models;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Random;

@Entity
public class Message {

    @Id
    private Long id;
    private String clientId;
    private String text;
    private LocalDateTime timeStamp;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User assignedTo;

    public Message(String clientId, String text) {
        Random random = new Random();
        this.id = 1000000 + Math.abs(random.nextLong()) % 9000000;
        this.clientId = clientId;
        this.text = text;
        timeStamp = LocalDateTime.now();
    }

    public Message() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }
}
