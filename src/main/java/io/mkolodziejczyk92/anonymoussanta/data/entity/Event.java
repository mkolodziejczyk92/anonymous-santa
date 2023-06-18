package io.mkolodziejczyk92.anonymoussanta.data.entity;

import io.mkolodziejczyk92.anonymoussanta.data.enums.ECurrency;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "event")
public class Event extends IdCreator{

    private String name;

    @Column(name = "event_date")
    private LocalDate eventDate;

    @Column(name = "number_of_people")
    private Integer numberOfPeople;

    private Integer budget;

    @Enumerated(EnumType.STRING)
    private ECurrency eCurrency;

    @Column(name = "registration_code")
    private String registrationCode;

    @OneToOne
    @JoinColumn(name = "organizer_id")
    private User organizer;

    @OneToOne
    private Family family;

}
