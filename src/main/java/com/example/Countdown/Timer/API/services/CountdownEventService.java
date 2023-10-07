package com.example.Countdown.Timer.API.services;


import com.example.Countdown.Timer.API.DTOs.CountdownEventDTO;
import com.example.Countdown.Timer.API.Exceptions.EventNotFoundException;
import com.example.Countdown.Timer.API.models.CountdownEvent;
import com.example.Countdown.Timer.API.repositories.CountdownEventRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CountdownEventService {

    private final CountdownEventRepository countdownEventRepository;

    public CountdownEventDTO createCountdownEvent(CountdownEventDTO countdownEventDTO) {

        if (countdownEventDTO.getEventName() == null  || countdownEventDTO.getEventDateTime() == null) {
            throw new IllegalArgumentException("Event name and date/time are required.");
        }

        CountdownEvent countdownEvent = new CountdownEvent();
        countdownEvent.setEventName(countdownEventDTO.getEventName());
        countdownEvent.setEventDateTime(LocalDateTime.parse(countdownEventDTO.getEventDateTime()));
        countdownEvent.setEventDescription(countdownEventDTO.getEventDescription());

        countdownEventRepository.save(countdownEvent);

        calculateCountdown(countdownEvent);

        return countdownEventDTO;
    }



    public CountdownEventDTO updateCountdownEvent(Long eventID, CountdownEventDTO updatedEventDTO) throws EventNotFoundException {
        // Retrieve the event by its ID from the database
        Optional<CountdownEvent> eventOptional = countdownEventRepository.findById(eventID);

        // Event with the given ID was not found
        if (eventOptional.isPresent()) {
            CountdownEvent existingEvent = eventOptional.get();

            // Update event details with the provided DTO
            existingEvent.setEventName(updatedEventDTO.getEventName());
            existingEvent.setEventDateTime(LocalDateTime.parse(updatedEventDTO.getEventDateTime()));

            // Save the updated event to the database
            CountdownEvent updatedEvent = countdownEventRepository.save(existingEvent);

            // Updated event to a DTO and return it

            return getCountdownEventDTO(updatedEvent);
        } else {
            // Event with the given ID was not found
            throw new EventNotFoundException("Event with ID " + eventID + " not found.");
        }
    }



    public void deleteCountdownEvent(Long eventID) throws EventNotFoundException {
        // Retrieve the event by its ID from the database
        Optional<CountdownEvent> eventOptional = countdownEventRepository.findById(eventID);

        // Event with the given ID was not found
        if (eventOptional.isPresent()) {
            CountdownEvent event = eventOptional.get();

            // Delete the event from the database
            countdownEventRepository.delete(event);
        } else {
            // Event with the given ID was not found
            throw new EventNotFoundException("Event with ID " + eventID + " not found.");
        }
    }



    public CountdownEventDTO getCountdownEvent(Long eventID) throws EventNotFoundException {

        // Retrieve the event by its ID from the database
        Optional<CountdownEvent> eventOptional = countdownEventRepository.findByEventId(eventID);

        // Event with the given ID was not found
        if (eventOptional.isPresent()) {
            CountdownEvent event = eventOptional.get();

            // An EventDTO to represent the event

            return getCountdownEventDTO(event);
        } else throw new EventNotFoundException("Event with ID " + eventID + " not found.");

    }



    public List<CountdownEventDTO> getAllCountdownEvents() {
        List<CountdownEvent> events = countdownEventRepository.findAll();

        // Convert the list of CountdownEvent entities to CountdownEventDTOs

        return events.stream()
                .map(CountdownEventService::getCountdownEventDTO)
                .collect(Collectors.toList());
    }



    private static CountdownEventDTO getCountdownEventDTO(CountdownEvent updatedEvent) {
        CountdownEventDTO updatedEventResponse = new CountdownEventDTO();
        updatedEventResponse.setEventID(updatedEvent.getEventID());
        updatedEventResponse.setEventName(updatedEvent.getEventName());
        updatedEventResponse.setEventDateTime(String.valueOf(updatedEvent.getEventDateTime()));
        updatedEventResponse.setCountdownDays(updatedEvent.getCountdownDays());
        updatedEventResponse.setCountdownHours(updatedEvent.getCountdownHours());
        updatedEventResponse.setCountdownMinutes(updatedEvent.getCountdownMinutes());
        updatedEventResponse.setCountdownSeconds(updatedEvent.getCountdownSeconds());
        return updatedEventResponse;
    }



    private void calculateCountdown(CountdownEvent event) {
        LocalDateTime eventDateTime = event.getEventDateTime();
        LocalDateTime currentDateTime = LocalDateTime.now();

        // Calculate the duration between the current time and the event time
        Duration duration = Duration.between(currentDateTime, eventDateTime);

        // Extract days, hours, minutes, and seconds from the duration
        long days = duration.toDays();
        long hours = duration.toHours() % 24;
        long minutes = duration.toMinutes() % 60;
        long seconds = duration.getSeconds() % 60;

        // Store the countdown values in the event entity
        event.setCountdownDays(days);
        event.setCountdownHours(hours);
        event.setCountdownMinutes(minutes);
        event.setCountdownSeconds(seconds);

        // Update the event in the database
        countdownEventRepository.save(event);
    }

}