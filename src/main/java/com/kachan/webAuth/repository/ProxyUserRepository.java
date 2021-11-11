package com.kachan.webAuth.repository;

import com.kachan.webAuth.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface ProxyUserRepository extends JpaRepository<User, Integer> {
    Optional<User> findUserByEmail(String email);

    @Override
    @Transactional
    <S extends User> S save(S entity);
}
