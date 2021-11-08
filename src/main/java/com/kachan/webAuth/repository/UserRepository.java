package com.kachan.webAuth.repository;

import com.kachan.webAuth.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findUserByEmail(String email);

    Optional<User> findUserByFirstName(String firstName);
}
