package io.mkolodziejczyk92.anonymoussanta.data.model;


import io.mkolodziejczyk92.anonymoussanta.data.entity.Family;
import io.mkolodziejczyk92.anonymoussanta.data.entity.User;
import io.mkolodziejczyk92.anonymoussanta.data.enums.ECurrency;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

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
    private ECurrency eCurrency;
    private String registrationCode;
    private User organizer;
    private Family family;
}
