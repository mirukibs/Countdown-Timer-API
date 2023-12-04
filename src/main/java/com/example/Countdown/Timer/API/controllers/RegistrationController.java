package com.example.Countdown.Timer.API.controllers;

import com.example.Countdown.Timer.API.DTOs.AuthResponseDTO;
import com.example.Countdown.Timer.API.DTOs.LoginDto;
import com.example.Countdown.Timer.API.DTOs.RegisterationDto;
import com.example.Countdown.Timer.API.configurations.JWTGenerator;
import com.example.Countdown.Timer.API.services.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1")
@AllArgsConstructor
public class RegistrationController {

    @Autowired
    private final RegistrationService registrationService;
    private final AuthenticationManager authenticationManager;
    private final JWTGenerator jwtGenerator;

    @PostMapping(path = "/registration", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String registerCustomer(@RequestBody RegisterationDto userRequest) {
        return registrationService.registerUser(userRequest);
    }


    @PostMapping(path = "/login", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AuthResponseDTO> login(@RequestBody LoginDto loginDto){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDto.getUsername(),
                        loginDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtGenerator.generateToken(authentication);
        return new ResponseEntity<>(new AuthResponseDTO(token), HttpStatus.OK);
    }

}