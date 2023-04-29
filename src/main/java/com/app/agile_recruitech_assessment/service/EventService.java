package com.app.agile_recruitech_assessment.service;

import com.app.agile_recruitech_assessment.dto.EventDto;

import java.util.HashMap;
import java.util.List;

public interface EventService {
    List<EventDto> getEvents();

    EventDto getEvent(Long id);

    List<EventDto> getPagedEvents(String type, int limit, int page);

    EventDto createOrUpdateEvent(EventDto eventDto);

    HashMap<String, Object> deleteEvent(Long id);
}
