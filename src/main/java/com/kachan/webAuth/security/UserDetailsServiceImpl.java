package com.kachan.webAuth.security;

import com.kachan.webAuth.model.User;
import com.kachan.webAuth.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetailsServiceImpl")
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserService userService;

    public UserDetailsServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user;

        if (s.contains("@")){
            user = userService.findUserByEmail(s);
        } else {
            user = userService.findUserByFirstName(s);
        }
        System.out.println(user);
        return SecurityUser.buildUserDetails(user);
    }
}
