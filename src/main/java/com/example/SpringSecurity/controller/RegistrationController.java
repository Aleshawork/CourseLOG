package com.example.SpringSecurity.controller;

import com.example.SpringSecurity.dto.RegistrationRequestDto;
import com.example.SpringSecurity.dto.UserDto;
import com.example.SpringSecurity.entity.Authority;
import com.example.SpringSecurity.entity.User;
import com.example.SpringSecurity.service.RegistrationService;
import com.example.SpringSecurity.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/signup")
public class RegistrationController {

    @Autowired
    RegistrationService registrationService;


    @PostMapping(value = "/newuser")
    public RegistrationRequestDto signUp(@RequestBody UserDto userDto){
        log.info("Received user with username:" + userDto.getUsername());
        return  registrationService.registrateUser(userDto);

    }

}
