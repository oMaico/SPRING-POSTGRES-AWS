package com.uskhalifa.eventoapi.controller;

import com.sun.jdi.request.EventRequest;
import com.uskhalifa.eventoapi.domain.event.Event;
import com.uskhalifa.eventoapi.domain.event.EventRequestDTO;
import com.uskhalifa.eventoapi.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/event")
public class EventController {

    @Autowired
    private EventService eventService;

    public ResponseEntity<Event> create(@RequestBody EventRequestDTO eventBody) {

        Event newEvent = this.eventService.createEvent(eventBody);
        return ResponseEntity.ok(newEvent);

    }

}
