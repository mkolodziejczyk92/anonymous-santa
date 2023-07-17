package io.mkolodziejczyk92.anonymoussanta.data.model;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class EventDto {

    private String name;
    private LocalDate eventDate;
    private Integer numberOfPeople;
    private Integer budget;
    private String currency;
    private String eventPassword;
    private String organizerId;
    private List<InvitationDto> listOfInvitationForEvent;
}
