package com.greenfoxacademy.p2pchat.Services.Main;

import com.greenfoxacademy.p2pchat.Models.Log;
import com.greenfoxacademy.p2pchat.Repositories.LogRepository;
import com.greenfoxacademy.p2pchat.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MainServiceImpl implements MainService {

    private final LogRepository logRepository;
    private final UserRepository userRepository;

    @Autowired
    public MainServiceImpl(LogRepository logRepository, UserRepository userRepository) {
        this.logRepository = logRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void log() {
        Log log = new Log(true, "/", "GET");
        logRepository.save(log);
    }

    @Override
    public boolean userRepoCheck() {
        return (userRepository.count() >= 1);
    }
}

