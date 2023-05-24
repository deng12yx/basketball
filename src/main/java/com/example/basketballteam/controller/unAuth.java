package com.example.basketballteam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class unAuth {
    @RequestMapping("/unAuth")
    public String unAuth() {
        return "unAuth";
    }
}
