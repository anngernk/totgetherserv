package org.example.totgether3.event;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.totgether3.event.dto.CreateEventRequest;
import org.example.totgether3.event.dto.EventDto;
import org.example.totgether3.user.UserService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class EventService {

    private final UserService userService;
    private final EventRepository eventRepository;
    private static final DateTimeFormatter DATE_TIME_FORMAT = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public void createEvent(CreateEventRequest createEventRequest) {
        var user = userService.getCurrentUser();
        var date = LocalDateTime.parse(createEventRequest.getDate(), DATE_TIME_FORMAT);
        var event = Event.builder()
                .patientName(createEventRequest.getPatientName())
                .date(date)
                .room(createEventRequest.getRoom())
                .reason(createEventRequest.getReason())
                .user(user)
                .build();

        eventRepository.save(event);
    }

    public List<EventDto> getEvents(String dateStr) {
        var user = userService.getCurrentUser();
        var date = LocalDate.parse(dateStr, DATE_FORMAT);
        var startOfDay = date.atStartOfDay();
        var endOfDay = date.atTime(23, 59, 59);

        return eventRepository.findAllByUserAndDateBetween(user, startOfDay, endOfDay).stream().map(event -> new EventDto(
                event.getPatientName(),
                event.getDate().format(DATE_FORMAT),
                event.getRoom(),
                event.getReason()
        )).toList();
    }
}
