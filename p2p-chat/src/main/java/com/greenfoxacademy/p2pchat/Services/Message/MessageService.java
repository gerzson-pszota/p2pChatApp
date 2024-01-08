package com.greenfoxacademy.p2pchat.Services.Message;

import com.greenfoxacademy.p2pchat.Models.Message;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MessageService {
    List<Message> findAll();
    void send(String clientId, String messageText);
}
