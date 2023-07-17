package io.mkolodziejczyk92.anonymoussanta.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.mkolodziejczyk92.anonymoussanta.data.enums.ERole;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "user")
public class User extends IdCreator {

    private String email;

    @JsonIgnore
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Enumerated(EnumType.STRING)
    private ERole role;

    @OneToMany
    private List<Invitation> invitations;





}
