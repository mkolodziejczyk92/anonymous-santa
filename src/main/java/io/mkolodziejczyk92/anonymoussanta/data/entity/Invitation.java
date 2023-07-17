package io.mkolodziejczyk92.anonymoussanta.data.entity;

import jakarta.persistence.*;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "invitation")
public class Invitation extends IdCreator{

    @Column(name = "participant_name")
    private String participantName;

    @Column(name = "participant_surname")
    private String participantSurname;

    @Column(name = "participant_email")
    private String participantEmail;

    @Column(name = "participant_status")
    private boolean participantStatus;

    @Column(name = "event_password")
    private String eventPassword;
    @ManyToOne
    private Event event;

    @OneToOne
    private User user;
}
