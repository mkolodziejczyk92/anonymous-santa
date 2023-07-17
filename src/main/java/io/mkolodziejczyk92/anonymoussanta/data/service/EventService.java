package io.mkolodziejczyk92.anonymoussanta.data.service;

import io.mkolodziejczyk92.anonymoussanta.data.entity.Event;
import io.mkolodziejczyk92.anonymoussanta.data.model.EventDto;
import io.mkolodziejczyk92.anonymoussanta.data.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class EventService {
    private final EventRepository eventRepository;
    private final InvitationService invitationService;
    private final UserService userService;

    public EventService(EventRepository eventRepository, InvitationService invitationService, UserService userService) {
        this.eventRepository = eventRepository;
        this.invitationService = invitationService;
        this.userService = userService;
    }

    public Event getEventById(Long eventId){
        return eventRepository.findById(eventId).orElseThrow();
    }

    //TODO: add transactional annotation
    public void saveEvent(EventDto eventDto) {
        Event event = Event.builder()
                .name(eventDto.getName())
                .eventDate(eventDto.getEventDate())
                .numberOfPeople(eventDto.getNumberOfPeople())
                .budget(eventDto.getBudget())
                .currency(eventDto.getCurrency())
                .eventPassword(getEventPassword())
                .organizer(userService.getUserById(eventDto.getOrganizerId()))
                .build();

        Event eventWithId = eventRepository.save(event);
        eventWithId.setListOfInvitationForEvent(
                invitationService.getListOfInvitationEntities(
                        eventDto.getListOfInvitationForEvent(), eventWithId)
        );
        eventRepository.save(eventWithId);
    }

    public static String getEventPassword() {
        final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        final int PASSWORD_LENGTH = 10;
        StringBuilder password = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < PASSWORD_LENGTH; i++) {
            int index = random.nextInt(CHARACTERS.length());
            char character = CHARACTERS.charAt(index);
            password.append(character);
        }
        return password.toString();
    }
}
