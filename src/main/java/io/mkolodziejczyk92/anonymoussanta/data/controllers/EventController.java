package io.mkolodziejczyk92.anonymoussanta.data.controllers;

import io.mkolodziejczyk92.anonymoussanta.data.model.EventDto;
import io.mkolodziejczyk92.anonymoussanta.data.service.EventService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/event")
public class EventController {
    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping
    public ResponseEntity<String> createEvent(@RequestBody EventDto eventDto) {
        try {
            eventService.saveEvent(eventDto);
            return ResponseEntity.ok("Wydarzenie zostało zapisane.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Wystąpił błąd podczas zapisywania wydarzenia.");
        }
    }

//    @GetMapping
//    public List<EventDto> getAllEvents() {
//        return EventService.getAllEventsForUser();
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteOfferById(@PathVariable Long id) {
//        eventService.deleteEvent(id);
//    }

}
