package io.mkolodziejczyk92.anonymoussanta.data.controllers;

import io.mkolodziejczyk92.anonymoussanta.data.model.EventDto;
import io.mkolodziejczyk92.anonymoussanta.data.service.EventService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/event")
public class EventController {
    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping
    public void createEvent(@RequestBody EventDto eventDto) {
        EventDto savedEvent = eventService.saveEvent(eventDto);
    }

    @GetMapping
    public List<EventDto> getAllEvents() {
        return EventService.getAllEvents();
    }

    @PutMapping("/{id}")
    public void updateOfferById(@RequestBody EventDto eventDto, @PathVariable Long id) {
        eventService.updateEventById(id, eventDto);
    }

    @DeleteMapping("/{id}")
    public void deleteOfferById(@PathVariable Long id) {
        eventService.deleteEvent(id);
    }

}
