package io.mkolodziejczyk92.anonymoussanta.data.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.mkolodziejczyk92.anonymoussanta.data.enums.ERole;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class UserDto {

    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String registrationCode;
    private Set<ERole> userRoles;
}
