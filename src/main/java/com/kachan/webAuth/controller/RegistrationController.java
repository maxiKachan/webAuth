package com.kachan.webAuth.controller;

import com.kachan.webAuth.model.Role;
import com.kachan.webAuth.model.User;
import com.kachan.webAuth.service.UserService;
import com.kachan.webAuth.util.CheckUserUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public RegistrationController(UserService userService, PasswordEncoder passwordEncoder){
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }

    @PostMapping("/registration")
    public ResponseEntity<?> createUser(@ModelAttribute("user") User user){
        System.out.println(user);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
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
