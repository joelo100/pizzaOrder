package com.joe.pizzaorderservice.security;

import com.joe.pizzaorderservice.models.User;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;

public class UserMapper {
    public static UserPrincipal userToPrincipal(User user) {
        UserPrincipal userp = new UserPrincipal();
        ArrayList<SimpleGrantedAuthority> authList = new ArrayList<SimpleGrantedAuthority>();
                authList.add(
                new SimpleGrantedAuthority("ROLE_AUTHORIZED_USER"));

        userp.setUsername(user.getUsername());
        userp.setPassword(user.getPassword());
        userp.setEnabled(true);
        userp.setAuthorities(authList);
        return userp;
    }
}