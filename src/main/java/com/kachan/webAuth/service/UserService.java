package com.kachan.webAuth.service;

import com.kachan.webAuth.model.User;

public interface UserService {
    User findUserByEmail(String email);

    User findUserByFirstName(String firstName);

    User addUser(User user);
}
