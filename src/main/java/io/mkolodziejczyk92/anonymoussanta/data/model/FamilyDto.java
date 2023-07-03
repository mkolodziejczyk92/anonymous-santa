package io.mkolodziejczyk92.anonymoussanta.data.model;


import io.mkolodziejczyk92.anonymoussanta.data.entity.User;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class FamilyDto {

    private String name;
    private String registrationCode;
    private User owner;
    private List<User> invitedUsers;

}
