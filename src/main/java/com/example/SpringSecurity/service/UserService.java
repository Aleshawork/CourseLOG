package com.example.SpringSecurity.service;

import com.example.SpringSecurity.entity.User;

import java.util.List;

public interface UserService {

    User findByNameAndSurname(String name, String surname);
    User findByGroup(String nyumber);
    List<User> findAll();
    User findByUsername(String username);
}
