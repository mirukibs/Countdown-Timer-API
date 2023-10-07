package com.example.Countdown.Timer.API.controllers;

import com.example.Countdown.Timer.API.DTOs.CountdownEventDTO;
import com.example.Countdown.Timer.API.services.CountdownEventService;
import com.example.Countdown.Timer.API.services.EventNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
public class CountdownEventController {

    @Autowired
    private CountdownEventService countdownEventService;

    // Create a new countdown event
    @PostMapping("/create")
    public ResponseEntity<CountdownEventDTO> createEvent(@RequestBody CountdownEventDTO eventDTO) {
        CountdownEventDTO createdEvent = countdownEventService.createCountdownEvent(eventDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEvent);
    }

    // Retrieve a countdown event by its ID
    @GetMapping("show-event/{eventID}")
    public ResponseEntity<CountdownEventDTO> getEvent(@PathVariable Long eventID) throws EventNotFoundException {
        CountdownEventDTO event = countdownEventService.getCountdownEvent(eventID);
        return ResponseEntity.ok(event);
    }

    // Update a countdown event by its ID
    @PutMapping("update-event/{eventID}")
    public ResponseEntity<CountdownEventDTO> updateEvent(
            @PathVariable Long eventID,
            @RequestBody CountdownEventDTO updatedEventDTO
    ) throws EventNotFoundException {
        CountdownEventDTO updatedEvent = countdownEventService.updateCountdownEvent(eventID, updatedEventDTO);
        return ResponseEntity.ok(updatedEvent);
    }

    // Delete a countdown event by its ID
    @DeleteMapping("delete-event/{eventID}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Long eventID) throws EventNotFoundException {
        countdownEventService.deleteCountdownEvent(eventID);
        return ResponseEntity.noContent().build();
    }

    // Get a list of all countdown events
    @GetMapping("/all-events")
    public ResponseEntity<List<CountdownEventDTO>> getAllEvents() {
        List<CountdownEventDTO> events = countdownEventService.getAllCountdownEvents();
        return ResponseEntity.ok(events);
    }
}
