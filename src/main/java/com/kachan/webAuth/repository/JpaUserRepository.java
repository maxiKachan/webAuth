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
    public Optional<User> findUserByFirstName(String firstName) {
        return proxy.findUserByFirstName(firstName);
    }

    @Override
    public void addUser(User user) {
        User userByEmail = proxy.findUserByEmail(user.getEmail()).orElse(null);
        User userByFirstName = proxy.findUserByFirstName(user.getFirstName()).orElse(null);
        if (userByEmail == null && userByFirstName == null) {
            proxy.save(user);
        }
    }
}
