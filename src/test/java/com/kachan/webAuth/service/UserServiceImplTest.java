package com.kachan.webAuth.service;

import com.kachan.webAuth.model.Role;
import com.kachan.webAuth.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;

import static com.kachan.webAuth.util.TestHelper.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
@Sql(scripts = "classpath:db/createAndPopDB.sql", config = @SqlConfig(encoding = "UTF-8"))
class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Test
    void findUserByEmail() {
        User user = userService.findUserByEmail("user@gmail.com");
        assertEquals(EXPECTED_FIND_USER_BY_EMAIL, user);
    }

    @Test
    void findUserByWrongEmail(){
        User user = userService.findUserByEmail("wrong@gmail.com");
        assertNull(user);
    }

    @Test
    void addUser() {
        User user = new User("test@gmail.com", "test","test","test", Role.USER);
        User addedUser = userService.addUser(user);
        assertEquals(EXPECTED_ADD_USER, addedUser);
        User findAddedUser = userService.findUserByEmail("test@gmail.com");
        assertEquals(EXPECTED_ADD_USER, findAddedUser);
    }

    @Test
    void addUserWithoutEmail(){
        User user = new User("", "test","test","test", Role.USER);
        User addedUser = userService.addUser(user);
        assertNull(addedUser);
    }

    @Test
    void addUserWithoutFirstName(){
        User user = new User("test@gmail.com", "","test","test", Role.USER);
        User addedUser = userService.addUser(user);
        assertNull(addedUser);
    }

    @Test
    void addUserWithoutPassword(){
        User user = new User("test@gmail.com", "test","test","", Role.USER);
        User addedUser = userService.addUser(user);
        assertNull(addedUser);
    }

    @Test
    void addUserWithoutLastName(){
        User user = new User("test@gmail.com", "test","","test", Role.USER);
        User addedUser = userService.addUser(user);
        assertEquals(EXPECTED_ADD_USER_WITHOUT_LASTNAME, addedUser);
        User findAddedUser = userService.findUserByEmail("test@gmail.com");
        assertEquals(EXPECTED_ADD_USER_WITHOUT_LASTNAME, findAddedUser);
    }
}