package com.kachan.webAuth.service;

import com.kachan.webAuth.model.User;
import com.kachan.webAuth.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserRepositoryImpl implements UserService{

    private final UserRepository userRepository;

    public UserRepositoryImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findUserByEmail(email).orElse(null);
    }

    @Override
    public User findUserByFirstName(String firstName) {
        return userRepository.findUserByFirstName(firstName).orElse(null);
    }
}
