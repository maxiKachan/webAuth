package com.kachan.webAuth.repository;

import com.kachan.webAuth.model.User;

import java.util.Optional;


public interface UserRepository {
    Optional<User> findUserByEmail(String email);

    Optional<User> findUserByFirstName(String firstName);

    User addUser(User user);
}
