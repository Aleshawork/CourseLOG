package com.example.SpringSecurity.controller;

import com.example.SpringSecurity.entity.User;
import com.example.SpringSecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/users")
public class UserController {

    @Autowired
    private UserService userService;



    @GetMapping(value = "/getall")
    public List<User> getAll(){
       return userService.findAll();
    }

    @GetMapping(value = "/{username}")
    public User getByUserName(@PathVariable(value = "username") String username){
        return userService.findByUsername(username);
    }
}
