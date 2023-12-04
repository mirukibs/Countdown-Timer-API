package com.example.Countdown.Timer.API.DTOs;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CountdownEventDTO {

    private long eventID;
    private String eventName;
    private LocalDateTime eventDateTime;
    private String eventDescription;
    private long countdownDays;
    private long countdownHours;
    private long countdownMinutes;
    private long countdownSeconds;

}
