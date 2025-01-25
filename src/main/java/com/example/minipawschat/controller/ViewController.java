package com.example.minipawschat.controller;

import org.checkerframework.checker.units.qual.C;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created on 2025-01-24 by 최윤서
 */
@Controller
public class ViewController {

    @GetMapping("/")
    public String main() {
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/chat")
    public String chat() {
        return "chat";
    }

    @GetMapping("/myChat-list.html")
    public String myChatList() {
        return "myChat-list";
    }

    @GetMapping("/createRoom")
    public String createRoom() {
        return "createRoom";
    }
}
