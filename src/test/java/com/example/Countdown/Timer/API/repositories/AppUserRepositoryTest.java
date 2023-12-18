package com.example.Countdown.Timer.API.repositories;

import com.example.Countdown.Timer.API.models.UserEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class AppUserRepositoryTest {

    @Autowired
    private  AppUserRepository underTest;

    @Test
    void itFindsUserByUsername() {

        // Given

        String username = "kaysam";

        UserEntity userEntity = new UserEntity(
                "Kibwana",
                "Miruru",
                username,
                "kaysam@gmail.com",
                "password"
        );

        underTest.save(userEntity);

        // When

            Optional<UserEntity> expected = underTest.findByUsername(username);

        // Then

            assertThat(expected).isPresent();

    }
}