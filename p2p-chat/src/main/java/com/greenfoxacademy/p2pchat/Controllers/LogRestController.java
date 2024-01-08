package com.greenfoxacademy.p2pchat.Controllers;

import com.greenfoxacademy.p2pchat.Services.Log.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LogRestController {

    private final LogService logService;

    @Autowired
    public LogRestController(LogService logService) {
        this.logService = logService;
    }

    @GetMapping("/log")
    public ResponseEntity log() {
        return logService.log();
    }
}
