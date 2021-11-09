package com.kachan.webAuth.controller;

import com.kachan.webAuth.model.Role;
import com.kachan.webAuth.model.User;
import com.kachan.webAuth.service.UserService;
import com.kachan.webAuth.util.CheckUserUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {

    private final UserService userService;

    public RegistrationController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }

    @PostMapping("/registration")
    public ResponseEntity<?> createUser(@ModelAttribute("user") User user){
        System.out.println("!!!");
        System.out.println(user);
        if (user.getRole() == null){
            user.setRole(Role.USER);
        }
        if (CheckUserUtil.checkUser(user)){
            userService.addUser(user);
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
