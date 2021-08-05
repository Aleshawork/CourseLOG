package com.example.SpringSecurity.security;

import com.example.SpringSecurity.entity.User;

public class JwtUserFactory {

    public static MyUserPrincipal createUser(User user){
        return new MyUserPrincipal(
                user.getUsername(),
                user.getPassword()
        );
    }
}
