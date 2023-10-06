package com.example.Countdown.Timer.API.repositories;

import com.example.Countdown.Timer.API.models.CountdownEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface CountdownEventRepository extends JpaRepository<CountdownEvent, Long> {

    Optional<CountdownEvent> findByEventId(Long eventID);

}
