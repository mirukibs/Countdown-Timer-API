package com.example.Countdown.Timer.API.repositories;

import com.example.Countdown.Timer.API.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(readOnly = true) // This annotation is used to prevent the database from locking the table when reading data
public interface AppUserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByUsername(String username); // This method is used in AppUserService.java

//    Optional<UserEntity> findByPhoneNumberAndFirstNameAndLastName(String phoneNumber, String firstName, String lastName);



    // This method is used in AppUserService.java

}