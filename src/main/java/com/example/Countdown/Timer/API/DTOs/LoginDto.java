package com.example.Countdown.Timer.API.DTOs;

import lombok.*;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
@ToString
public class LoginDto {

    private String username;
    private String password;

}