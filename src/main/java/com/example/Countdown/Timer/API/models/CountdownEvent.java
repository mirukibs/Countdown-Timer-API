package com.example.Countdown.Timer.API.models;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CountdownEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long eventID;
    @Column(nullable = false)
    private String eventName;
    @Column(nullable = false)
//    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssXXX")
    private LocalDateTime eventDateTime;
    private String eventDescription;
    private long countdownDays;
    private long countdownHours;
    private long countdownMinutes;
    private long countdownSeconds;
    @ManyToOne
    @JoinColumn(name = "user_id")  // Assuming the column name in the database
    private UserEntity user;

}
