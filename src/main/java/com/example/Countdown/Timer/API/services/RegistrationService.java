package com.example.Countdown.Timer.API.services;

import com.example.Countdown.Timer.API.DTOs.RegisterationDto;
import com.example.Countdown.Timer.API.models.Role;
import com.example.Countdown.Timer.API.models.UserEntity;
import com.example.Countdown.Timer.API.repositories.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@AllArgsConstructor
public class RegistrationService {

    @Autowired
    private final AppUserService appUserService;
    @Autowired
    private final RoleRepository roleRepository;

    public String registerUser(RegisterationDto request) {
        // TODO: Validate phone number

        UserEntity userEntity = new UserEntity();
        userEntity.setFirstname(request.getFirstname());
        userEntity.setLastname(request.getLastname());
        userEntity.setUsername(request.getUsername());
        userEntity.setPassword(request.getPassword());
        Role role = roleRepository.findByName("CUSTOMER").orElseThrow(() -> new RuntimeException("Role not found: CUSTOMER"));
        userEntity.setRoles(Collections.singletonList(role));

        return appUserService.signUpUser(userEntity);
    }

}