package org.rally.backend.eventsarm.controller;

import org.rally.backend.eventsarm.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/")
public class EventController {

    @Autowired
    private EventRepository eventRepository;

    @GetMapping("/events")
    public String displayAllEvents() {

        return "/events";
    }

    @GetMapping("/event")
    public String displayEventPage() {

        return "/event";
    }

    @GetMapping("/create")
    public String displayCreateEventForm() {


        return "/create";
    }

    @PostMapping("/create")
    public String processCreateEventForm() {

        return "/events";
    }




}
