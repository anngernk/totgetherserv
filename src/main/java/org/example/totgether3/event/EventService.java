package org.example.totgether3.event;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.totgether3.event.dto.CreateEventRequest;
import org.example.totgether3.user.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class EventService {

    private final UserService userService;
    private final EventRepository eventRepository;
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");

    public void createEvent(CreateEventRequest createEventRequest) {
        var user = userService.getCurrentUser();
        var date = LocalDateTime.parse(createEventRequest.getDate(), DATE_FORMATTER);
        var event = Event.builder()
                .patientName(createEventRequest.getPatientName())
                .date(date)
                .room(createEventRequest.getRoom())
                .reason(createEventRequest.getReason())
                .user(user)
                .build();

        eventRepository.save(event);
    }

    public List<Event> getEvents() {
        var user = userService.getCurrentUser();
        return eventRepository.findAllByUser(user);
    }
}
