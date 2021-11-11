package com.kachan.webAuth.service;

import com.kachan.webAuth.model.Role;
import com.kachan.webAuth.model.User;
import com.kachan.webAuth.repository.UserRepository;
import com.kachan.webAuth.util.CheckUserUtil;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findUserByEmail(email).orElse(null);
    }

    @Override
    public User addUser(User user) {
        if (user.getRole() == null){
            user.setRole(Role.USER);
        }
        if (CheckUserUtil.checkUser(user)){
            return userRepository.addUser(user);
        }
        return null;
    }
}
