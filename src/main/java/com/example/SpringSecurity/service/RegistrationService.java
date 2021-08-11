package com.example.SpringSecurity.service;

import com.example.SpringSecurity.dto.RegistrationRequestDto;
import com.example.SpringSecurity.dto.UserDto;
import com.example.SpringSecurity.entity.Authority;
import com.example.SpringSecurity.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class RegistrationService {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public RegistrationRequestDto registrateUser(UserDto userDto){
        if(userService.findByUsername(userDto.getUsername())==null) {


            User user = new User(
                    userDto.getName(),
                    userDto.getSurname(),
                    userDto.getUsername(),
                    passwordEncoder.encode(userDto.getPassword())
            );
            Authority authority = new Authority("ROLE_USER");
            authority.setUser(user);

            user.setAuthorities(List.of(authority));

            userService.save(user);
            log.info(String.format("Registrate user with username:", userDto.getUsername()));
            Date date = new Date();
            return new RegistrationRequestDto(
                    user.getUsername(),
                    date
            );
        }
        log.warn("attempt to add a user with an existing one username:"+userDto.getUsername());
        throw new SecurityException("User with username:"+userDto.getUsername()+" already exist");
    }
}
