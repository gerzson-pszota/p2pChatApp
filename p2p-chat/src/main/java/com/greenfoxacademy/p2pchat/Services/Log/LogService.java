package com.greenfoxacademy.p2pchat.Services.Log;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface LogService {
    ResponseEntity log();
}
