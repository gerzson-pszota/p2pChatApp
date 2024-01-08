package com.greenfoxacademy.p2pchat.Services.User;

import org.springframework.stereotype.Service;

@Service
public interface UserService {
    void register(String clientId);
    void update(String clientId);
}
