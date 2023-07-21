package io.mkolodziejczyk92.anonymoussanta.data.mapper;

import io.mkolodziejczyk92.anonymoussanta.data.entity.Invitation;
import io.mkolodziejczyk92.anonymoussanta.data.model.InvitationDto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface InvitationMapper {

    InvitationDto mapToInvitation(Invitation invitation);

    @InheritInverseConfiguration
    Invitation mapToInvitationDto(InvitationDto invitationDto);

    List<InvitationDto> mapToInvitationDtoList(List<Invitation> invitationList);

    @InheritInverseConfiguration
    List<Invitation> mapToInvitationList(List<InvitationDto> invitationDtoList);
}
