package org.example.totgether3.event;

import lombok.RequiredArgsConstructor;
import org.example.totgether3.event.dto.CreateEventRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/events")
public class EventController {

    private final EventService eventService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createEvent(@RequestBody CreateEventRequest createEventRequest) {
        eventService.createEvent(createEventRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Event> getEvents() {
        return eventService.getEvents();
    }

}
