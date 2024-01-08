package com.greenfoxacademy.p2pchat.Services.Message;

import com.greenfoxacademy.p2pchat.Models.Log;
import com.greenfoxacademy.p2pchat.Models.Message;
import com.greenfoxacademy.p2pchat.Repositories.LogRepository;
import com.greenfoxacademy.p2pchat.Repositories.MessageRepository;
import com.greenfoxacademy.p2pchat.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    private MessageRepository messageRepository;
    private LogRepository logRepository;

    @Autowired
    public MessageServiceImpl(MessageRepository messageRepository, LogRepository logRepository) {
        this.messageRepository = messageRepository;
        this.logRepository = logRepository;
    }

    @Override
    public List<Message> findAll() {
        return messageRepository.findAllByOrderByTimeStamp();
    }

    @Override
    public void send(String clientId, String messageText) {
        String data = "POST" + " " + "messageText=" + messageText;
        Log log = new Log(true, "/send", data);
        Message message = new Message(clientId, messageText);
        messageRepository.save(message);
        logRepository.save(log);
    }
}
