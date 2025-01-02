package org.example.totgether3.event;

import lombok.RequiredArgsConstructor;
import org.example.totgether3.event.dto.CreateEventRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/event")
public class EventController {

    private final EventService eventService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createEvent(CreateEventRequest createEventRequest) {
        eventService.createEvent(createEventRequest);
    }

}
