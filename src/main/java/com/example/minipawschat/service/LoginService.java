package com.example.minipawschat.service;

import com.example.minipawschat.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created on 2025-01-24 by 최윤서
 */
@Service
public class LoginService {
    @Autowired
    private UserRepository userRepository;

    public boolean authenticate(String username, String password) {
        return userRepository.findByUsername(username)
                .map(user -> password.equals(user.getPassword())) // 단순 문자열 비교
                .orElse(false);
    }
}
