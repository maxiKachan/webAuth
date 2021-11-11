package com.kachan.webAuth.repository;

import com.kachan.webAuth.model.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class JpaUserRepository implements UserRepository{

    private final ProxyUserRepository proxy;

    public JpaUserRepository(ProxyUserRepository proxy){
        this.proxy = proxy;
    }

    @Override
    public Optional<User> findUserByEmail(String email) {
        return proxy.findUserByEmail(email);
    }

    @Override
    public User addUser(User user) {
        User addUser;
        User userByEmail = proxy.findUserByEmail(user.getEmail()).orElse(null);
        if (userByEmail == null) {
             addUser = proxy.save(user);
             return addUser;
        } else {
            return null;
        }

    }
}
