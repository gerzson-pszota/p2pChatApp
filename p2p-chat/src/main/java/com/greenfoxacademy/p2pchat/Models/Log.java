package com.greenfoxacademy.p2pchat.Models;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Logs")
public class Log {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime dateTime;
    private boolean isInfo; //true=info, false=error
    private String path;
    private String data; //log all request params from the endpoint

    public Log(boolean isInfo, String path, String data) {
        this.dateTime = LocalDateTime.now();
        this.path = path;
        this.data = data;
    }

    public Log() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public boolean isInfo() {
        return isInfo;
    }

    public void setInfo(boolean info) {
        isInfo = info;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        String type = isInfo ? "info" : "error";
        return dateTime + " " + type + " " + path + " " + data;
    }
}
