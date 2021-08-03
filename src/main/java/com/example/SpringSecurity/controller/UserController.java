package com.example.SpringSecurity.controller;

import com.example.SpringSecurity.entity.User;
import com.example.SpringSecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/student")
public class UserController {

    @Autowired
    private UserService suserService;

    @GetMapping(path = "/getall")
    public List<User> getAll(){
        return  suserService.findAll();
    }
}
