package com.example.Countdown.Timer.API.DTOs;

import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class RegisterationDto {

    private String firstname;
    private String lastname;
    private String username;
    private String password;

}