package com.example.minipawschat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created on 2025-01-23 by 최윤서
 */
@Controller
public class ChatContoller {

    @RequestMapping("/chat")
    public String chat() {
        return "chat";
    }
}
