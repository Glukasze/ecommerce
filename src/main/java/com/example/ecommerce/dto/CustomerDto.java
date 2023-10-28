package com.example.ecommerce.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CustomerDto {

    private int identifier;

    private String email;

    private String login;

    private LocalDate birthdate;

}
