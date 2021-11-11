package com.kachan.webAuth.service;

import com.kachan.webAuth.model.User;

public interface UserService {
    User findUserByEmail(String email);

    User addUser(User user);
}
