package com.greenfoxacademy.p2pchat.Services.Log;

import com.greenfoxacademy.p2pchat.Models.Log;
import com.greenfoxacademy.p2pchat.Repositories.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class LogServiceImpl implements LogService {

    private final LogRepository logRepository;

    @Autowired
    public LogServiceImpl(LogRepository logRepository) {
        this.logRepository = logRepository;
    }

    @Override
    public ResponseEntity log() {
        List<Log> logs = logRepository.findAll();
        Map<String, String> successResponse = new HashMap<>();
        successResponse.put(logs.toString(), "entry_count: " + logs.size());

        return ResponseEntity.status(200).body(successResponse);
    }
}
