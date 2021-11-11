package com.kachan.webAuth.util;

import com.kachan.webAuth.model.Role;
import com.kachan.webAuth.model.User;

public class TestHelper {

    public static final User EXPECTED_FIND_USER_BY_EMAIL = new User(1, "user@gmail.com", "user","user","user", Role.USER);
    public static final User EXPECTED_ADD_USER = new User(3, "test@gmail.com", "test","test","test", Role.USER);
    public static final User EXPECTED_ADD_USER_WITHOUT_LASTNAME = new User(3, "test@gmail.com", "test","","test", Role.USER);
}
