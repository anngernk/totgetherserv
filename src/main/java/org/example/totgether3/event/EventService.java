package org.example.totgether3.event;

import lombok.RequiredArgsConstructor;
import org.example.totgether3.event.dto.CreateEventRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
public class EventService {

    private final EventRepository eventRepository;
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy'T'HH:mm");

    public void createEvent(CreateEventRequest createEventRequest) {
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
