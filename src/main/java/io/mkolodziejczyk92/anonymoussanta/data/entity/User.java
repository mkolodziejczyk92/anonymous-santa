package io.mkolodziejczyk92.anonymoussanta.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.mkolodziejczyk92.anonymoussanta.data.enums.ERole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "user")
public class User extends IdCreator{

    private String username;

    @JsonIgnore
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private String email;

    @Column(name = "registration_code")
    private String registrationCode;

    @Enumerated(EnumType.STRING)
    @ElementCollection(fetch = FetchType.EAGER)
    private Set<ERole> userRoles;


}
