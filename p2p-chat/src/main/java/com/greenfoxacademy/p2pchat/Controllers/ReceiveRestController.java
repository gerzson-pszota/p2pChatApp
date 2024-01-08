package com.greenfoxacademy.p2pchat.Controllers;

import com.greenfoxacademy.p2pchat.Models.Message;
import com.greenfoxacademy.p2pchat.Services.Message.MessageService;
import com.greenfoxacademy.p2pchat.Services.Receive.ReceiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class ReceiveRestController {

    private ReceiveService receiveService;
    private MessageService messageService;

    @Autowired
    public ReceiveRestController(ReceiveService receiveService, MessageService messageService) {
        this.receiveService = receiveService;
        this.messageService = messageService;
    }

    @PostMapping("/api/message/receive")
    public ResponseEntity receive(@RequestParam(name = "id", required = false) Long id,
                                  @RequestParam(name = "username", required = false) String username,
                                  @RequestParam(name = "text", required = false) String text,
                                  @RequestParam(name = "timestamp", required = false)Long timestamp,
                                  @RequestParam(name = "clientId", required = false) String clientId) {

        StringBuilder errorMessage = new StringBuilder("Missing field(s): ");
        boolean hasMissingField = false;

        if (timestamp == null) {
            errorMessage.append("message.timestamp, ");
            hasMissingField = true;
        }

        if (clientId == null) {
            errorMessage.append("client.id, ");
            hasMissingField = true;
        }

        if (hasMissingField) {

            errorMessage.setLength(errorMessage.length() - 2);

            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("{\"status\": \"error\", \"message\": \"" + errorMessage.toString() + "\"}");
        }

        Message message = new Message(username,text);
        messageService.send(username, text);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
