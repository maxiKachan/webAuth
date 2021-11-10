package com.kachan.webAuth.security;

import com.kachan.webAuth.model.Role;
import com.kachan.webAuth.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class SecurityUser implements UserDetails {

    private final String username;
    private final String password;
    private final Role role;


    public SecurityUser(String username, String password, Role role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getSetAuthorities(role);
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public static UserDetails buildUserDetails(User user){

        return new org.springframework.security.core.userdetails.User(user.getFirstName(), user.getPassword(),
                SecurityUser.getSetAuthorities(user.getRole()));
    }

    @Override
    public String toString() {
        return "SecurityUser{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }

    private static Set<Role> getSetAuthorities(Role role){
        HashSet<Role> roles = new HashSet<>();
        roles.add(role);
        return roles;
    }
}
