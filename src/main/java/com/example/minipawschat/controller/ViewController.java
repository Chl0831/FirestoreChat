package com.example.minipawschat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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

    @GetMapping("/chat/{roomId}")
    public String chatRoom(@PathVariable String roomId, Model model) {
        model.addAttribute("roomId", roomId);
        return "chat";
    }

    @GetMapping("/myChat")
    public String myChatList() {
        return "myChat";
    }

    @GetMapping("/createRoom")
    public String createRoom() {
        return "createRoom";
    }

}
