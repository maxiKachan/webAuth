package com.kachan.webAuth.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestController {

    @GetMapping("/hello")
    public ResponseEntity<?> helloRest(Authentication authentication){
        if (authentication == null){
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return new ResponseEntity<>("Hello, " + userDetails.getUsername(), HttpStatus.OK);
    }
}
