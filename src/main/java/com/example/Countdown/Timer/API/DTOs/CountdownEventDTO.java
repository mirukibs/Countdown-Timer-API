package com.example.Countdown.Timer.API.DTOs;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CountdownEventDTO {

//    private long eventID;
    private String eventName;
    private String eventDate;
    private String eventTime;

}
