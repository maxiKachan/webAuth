package com.kachan.webAuth.repository;

import com.kachan.webAuth.model.Role;
import com.kachan.webAuth.model.User;
import com.kachan.webAuth.util.TestHelper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;

import static com.kachan.webAuth.util.TestHelper.EXPECTED_ADD_USER;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Sql(scripts = "classpath:db/createAndPopDB.sql", config = @SqlConfig(encoding = "UTF-8"))
class JpaUserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void findUserByEmail() {
        User user = userRepository.findUserByEmail("user@gmail.com").orElse(null);
        assertEquals(TestHelper.EXPECTED_FIND_USER_BY_EMAIL, user);
    }

    @Test
    void findNotExistsUserByEmail(){
        User user = userRepository.findUserByEmail("test@gmail.com").orElse(null);
        assertNull(user);
    }

    @Test
    void addUser() {
        User user = new User("test@gmail.com", "test","test","test", Role.USER);
        User addedUser = userRepository.addUser(user);
        assertEquals(EXPECTED_ADD_USER, addedUser);
        User findAddedUser = userRepository.findUserByEmail("test@gmail.com").orElse(null);
        assertEquals(EXPECTED_ADD_USER, findAddedUser);
    }
}