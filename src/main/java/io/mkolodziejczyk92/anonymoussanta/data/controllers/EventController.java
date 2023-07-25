package io.mkolodziejczyk92.anonymoussanta.data.controllers;

import io.mkolodziejczyk92.anonymoussanta.data.model.EventDto;
import io.mkolodziejczyk92.anonymoussanta.data.model.InvitationDto;
import io.mkolodziejczyk92.anonymoussanta.data.repository.EventRepository;
import io.mkolodziejczyk92.anonymoussanta.data.service.EventService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/event")
public class EventController {
    private final EventService eventService;
    private final EventRepository eventRepository;

    public EventController(EventService eventService,
                           EventRepository eventRepository) {
        this.eventService = eventService;
        this.eventRepository = eventRepository;
    }

    @PostMapping("/add")
    public ResponseEntity<String> createEvent(@RequestBody EventDto eventDto) {
        try {
            eventService.saveEventAndSendInvitationsToParticipants(eventDto);
            return ResponseEntity.ok("Event has been saved.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while trying to save the event.");
        }
    }

    @GetMapping("/user-events/{userId}")
    public ResponseEntity<List<EventDto>> getAllEventsForLogInUser(@PathVariable Long userId) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(eventService.getAllEventsByUserId(userId));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ArrayList<>());
        }
    }

    @DeleteMapping("/delete/{eventId}/{userId}")
    public ResponseEntity<String> deleteEventById(@PathVariable Long eventId, @PathVariable Long userId) {
        try {
            eventService.deleteEvent(eventId, userId);
            return ResponseEntity.ok("Event has been deleted");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while trying to delete the event.");
        }
    }

    @GetMapping("/participants-by-event-id/{eventId}/{userId}")
    public ResponseEntity<List<InvitationDto>> getAllParticipantsForEvent(@PathVariable Long eventId, @PathVariable Long userId){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(eventService.getAllParticipantsForEventByEventId(eventId, userId));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ArrayList<>());
        }
    }

    @PostMapping("/join-to-the-event")
    public ResponseEntity<String> joinToTheEvent(@RequestBody Map<String, String> request){
        try {
            eventService.joinToTheEvent(request);
            return ResponseEntity.ok("You joined to the event.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while trying to join the event.");
        }
    }

    @PostMapping("/draw/{eventId}/{userId}")
    public ResponseEntity<String> performAPairDraw(@PathVariable Long eventId, @PathVariable Long userId){
        try {
            eventService.makeDrawAndSendInformationToParticipantsAndSavePairsInDb(eventId, userId);
            return ResponseEntity.ok("The draw has been made");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred during the execution of the draw.");
        }
    }

}
