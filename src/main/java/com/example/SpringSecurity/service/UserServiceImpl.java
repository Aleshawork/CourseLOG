package com.example.SpringSecurity.service;

import com.example.SpringSecurity.entity.User;
import com.example.SpringSecurity.repository.UserRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    @Override
    public User findByNameAndSurname(String name, String surname) {
        User user = null;
        try {
             user = userRepository.findUserByNameAndSurname(name, surname)
                    .orElseThrow(() -> new NotFoundException(String.format("Student %s %s is not exist",name,surname)))
                    .stream().findFirst().get();
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public User findByGroup(String nyumber) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findByUsername(String username) {
        User user =null;
        try {
             user = userRepository.findUserByUsername(username).orElseThrow(()->new NotFoundException("User "+username + "is not exist"));
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
        return user;
    }
}
