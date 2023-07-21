package io.mkolodziejczyk92.anonymoussanta.data.service;

import io.mkolodziejczyk92.anonymoussanta.data.entity.Event;
import io.mkolodziejczyk92.anonymoussanta.data.entity.Invitation;
import io.mkolodziejczyk92.anonymoussanta.data.model.InvitationDto;
import io.mkolodziejczyk92.anonymoussanta.data.repository.InvitationRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InvitationService {

    private final InvitationRepository invitationRepository;

    public InvitationService(InvitationRepository invitationRepository) {
        this.invitationRepository = invitationRepository;
    }

    public List<Invitation> createListOfInvitationEntitiesForSavingEvent(List<InvitationDto> listOfInvitationForEvent, Event event) {
        List<Invitation> invitationEntities = new ArrayList<>();
        for (InvitationDto invitation: listOfInvitationForEvent) {
            invitationEntities.add(Invitation.builder()
                            .participantName(invitation.getParticipantName())
                            .participantSurname(invitation.getParticipantSurname())
                            .participantEmail(invitation.getParticipantEmail())
                            .participantStatus(false)
                            .eventPassword(null)
                            .event(event)
                            .user(null)
                    .build());
        }
        return invitationEntities;
    }

    public List<Invitation> getAllUserAcceptedInvitations(Long userId){
        return invitationRepository.findAllByParticipantStatusIsTrueAndUserId(userId);
    }

    public List<Invitation> getAllInvitationsForEvent(Long eventId) {
        return invitationRepository.findAllByEventId(eventId);
    }
}
