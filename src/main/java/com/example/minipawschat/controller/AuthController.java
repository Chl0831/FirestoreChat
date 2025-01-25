package com.example.minipawschat.controller;

import com.example.minipawschat.service.LoginService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created on 2025-01-24 by 최윤서
 */
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest request) {
        if (loginService.authenticate(request.getUsername(), request.getPassword())) {
            return ResponseEntity.ok("로그인 성공!");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("로그인 실패");
        }
    }
}

@Data
class LoginRequest {
    private String username;
    private String password;
}
