package com.app.agile_recruitech_assessment.controller;


import com.app.agile_recruitech_assessment.dto.EventDto;
import com.app.agile_recruitech_assessment.service.EventService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;


@RequestMapping("/api/v3/app")
@RestController
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping(value = "/events")
//To get all events
    ResponseEntity<List<EventDto>> getEvents() {
        List<EventDto> events = eventService.getEvents();
        return new ResponseEntity<>(events, HttpStatus.OK);
    }

    @GetMapping(value = "/events", params = {"id"})
//To get single event by id
    ResponseEntity<EventDto> getEvents(@RequestParam Long id) {
        EventDto eventDto = eventService.getEvent(id);
        return new ResponseEntity<>(eventDto, HttpStatus.OK);
    }


    @GetMapping(value = "/events", params = {"limit", "page"})
        //To get Paged event data
    ResponseEntity<List<EventDto>> getPagedEvents(
            @RequestParam(name = "type", required = false) String type,
            @RequestParam int limit,
            @RequestParam int page
    ) {
        return new ResponseEntity<>(eventService.getPagedEvents(type, limit, page), HttpStatus.OK);
    }


    @PostMapping("/events")
        //To create new Event
    ResponseEntity<EventDto> createEvent(@RequestBody EventDto eventDto) {
        return new ResponseEntity<>(eventService.createOrUpdateEvent(eventDto), HttpStatus.OK);
    }

    @PutMapping("/events")
        //To updating existing Event
    ResponseEntity<EventDto> updateEvent(@RequestBody EventDto eventDto) {
        return new ResponseEntity<>(eventService.createOrUpdateEvent(eventDto), HttpStatus.OK);
    }

    @DeleteMapping("/events/{id}")
    ResponseEntity<HashMap<String, Object>> deleteEvent(@PathVariable("id") Long id) {
        return new ResponseEntity<>(eventService.deleteEvent(id), HttpStatus.OK);
    }

}
