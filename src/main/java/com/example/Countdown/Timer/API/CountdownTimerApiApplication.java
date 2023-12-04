package com.example.Countdown.Timer.API;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling // Enable scheduling for the application
public class CountdownTimerApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CountdownTimerApiApplication.class, args);
	}

}
