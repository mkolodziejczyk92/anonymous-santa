package io.mkolodziejczyk92.anonymoussanta.data.mapper;

import io.mkolodziejczyk92.anonymoussanta.data.entity.Event;
import io.mkolodziejczyk92.anonymoussanta.data.model.EventDto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface EventMapper {

    EventDto mapToEventDto(Event event);

    @InheritInverseConfiguration
    Event mapToEvent(EventDto eventDto);

    List<EventDto> mapToEventDtoList(List<Event> eventList);

    @InheritInverseConfiguration
    List<Event> mapToEventList(List<EventDto> eventDtoList);

}
