package com.greenfoxacademy.p2pchat.Services.User;

import com.greenfoxacademy.p2pchat.Models.Log;
import com.greenfoxacademy.p2pchat.Models.User;
import com.greenfoxacademy.p2pchat.Repositories.LogRepository;
import com.greenfoxacademy.p2pchat.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class UserServiceImpl implements UserService {

    private final LogRepository logRepository;
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(LogRepository logRepository, UserRepository userRepository) {
        this.logRepository = logRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void register(String clientId) {
        String data = "POST" + " " + "clientId=" + clientId;
        Log log = new Log(true, "/register", data);

        User user = new User(clientId);

        userRepository.save(user);
        logRepository.save(log);
    }

    @Override
    public void update(String clientId) {
        String data = "POST" + " " + "clientId=" + clientId;
        Log log = new Log(true, "/update", data);

        User user = userRepository.findById(2L)
                .orElseThrow(() -> new EntityNotFoundException("User not found with ID: " + 2));
        user.setClientId(clientId);

        userRepository.saveAndFlush(user);
        logRepository.save(log);
    }
}
