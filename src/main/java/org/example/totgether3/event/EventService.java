package org.example.totgether3.event;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.totgether3.event.dto.CreateEventRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@Service
@RequiredArgsConstructor
public class EventService {

    private final EventRepository eventRepository;
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");

    public void createEvent(CreateEventRequest createEventRequest) {
        log.info("Creating event: {}", createEventRequest);
        var date = LocalDateTime.parse(createEventRequest.getDate(), DATE_FORMATTER);
        var event = Event.builder()
                .patientName(createEventRequest.getPatientName())
                .date(date)
                .room(createEventRequest.getRoom())
                .reason(createEventRequest.getReason())
                .build();

        eventRepository.save(event);
    }
}
