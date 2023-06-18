package io.mkolodziejczyk92.anonymoussanta.data.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "family")
public class Family extends IdCreator{


    private String name;

    @Column(name = "registration_code")
    private String registrationCode;

    @OneToOne
    @JoinColumn(name = "owner_id")
    private User owner;

    @OneToMany
    private List<User> invitedUsers;

}
