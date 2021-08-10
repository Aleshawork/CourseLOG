package com.example.SpringSecurity.service;

import com.example.SpringSecurity.dto.RegistrationRequestDto;
import com.example.SpringSecurity.dto.UserDto;
import com.example.SpringSecurity.entity.Authority;
import com.example.SpringSecurity.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class RegistrationService {

    @Autowired
    UserService userService;

    public RegistrationRequestDto registrateUser(UserDto userDto){
        User user = new User(
                userDto.getName(),
                userDto.getSurname(),
                userDto.getUsername(),
                userDto.getPassword()
        );
        Authority authority = new Authority("ROLE_USER");
        authority.setUser(user);

        user.setAuthorities(List.of(authority));

        userService.save(user);
        log.info(String.format("Registrate user with username:",userDto.getUsername()));
        Date date = new Date();
        return new RegistrationRequestDto(
                user.getUsername(),
                date
        );
    }
}
