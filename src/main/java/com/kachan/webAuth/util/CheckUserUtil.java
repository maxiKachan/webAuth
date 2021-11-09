package com.kachan.webAuth.util;

import com.kachan.webAuth.model.User;

public class CheckUserUtil {
    public static boolean checkUser(User user){
        return user.getEmail() != null && user.getFirstName() != null && user.getPassword() != null &&
                !user.getEmail().isEmpty() && !user.getFirstName().isEmpty() && !user.getPassword().isEmpty();
    }
}
