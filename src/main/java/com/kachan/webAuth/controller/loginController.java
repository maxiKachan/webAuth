package com.kachan.webAuth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class loginController {

    @GetMapping("/")
    public String redirectToLogin(){
        return "login";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

}
