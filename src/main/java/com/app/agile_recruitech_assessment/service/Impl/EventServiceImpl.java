package com.app.agile_recruitech_assessment.service.Impl;

import com.app.agile_recruitech_assessment.dto.EventDto;
import com.app.agile_recruitech_assessment.entity.Event;
import com.app.agile_recruitech_assessment.mapper.EventMapper;
import com.app.agile_recruitech_assessment.repository.EventRepository;
import com.app.agile_recruitech_assessment.service.EventService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;

    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public List<EventDto> getEvents() {
        List<Event> eventList = eventRepository.findAll();
        return eventList.stream().map(EventMapper::mapToEventDto).collect(Collectors.toList());
    }

    @Override
    public EventDto getEvent(Long id) {
        Optional<Event> eventOptional = eventRepository.findById(id);
        if (eventOptional.isPresent()) {
            return EventMapper.mapToEventDto(eventOptional.get());
        } else {
            throw new RuntimeException("event not found with id:" + id);
        }
    }

    @Override
    public List<EventDto> getPagedEvents(String type, int limit, int page) {
        page = page - 1;
        Pageable pageable = PageRequest.of(page, limit);
        Page<Event> pageEvents = eventRepository.findAll(pageable);
        List<Event> events = pageEvents.getContent();

        if (type == null || type.isBlank()) {
            return events.stream().map(EventMapper::mapToEventDto).collect(Collectors.toList());
        }
        return events.stream().filter(event -> event.getType().equals(type)).toList().stream().map(EventMapper::mapToEventDto).collect(Collectors.toList());
    }

    @Override
    public EventDto createOrUpdateEvent(EventDto eventDto) {
        Event event = eventRepository.save(EventMapper.mapToEvent(eventDto));
        return EventMapper.mapToEventDto(event);
    }

    @Override
    public HashMap<String, Object> deleteEvent(Long id) {
        eventRepository.deleteById(id);
        HashMap<String, Object> response = new HashMap<>();
        response.put("event_id", id);
        response.put("message", "success");
        response.put("status", HttpStatus.OK);
        return response;
    }

}
