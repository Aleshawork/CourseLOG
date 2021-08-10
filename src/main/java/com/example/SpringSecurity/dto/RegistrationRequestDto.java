package com.example.SpringSecurity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class RegistrationRequestDto {

    private String username;
    private Date dateCreation;
}
