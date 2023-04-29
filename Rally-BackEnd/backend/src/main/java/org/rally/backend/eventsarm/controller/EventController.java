package org.rally.backend.eventsarm.controller;

import org.rally.backend.eventsarm.models.Event;
import org.rally.backend.eventsarm.repository.EventRepository;
import org.rally.backend.userprofilearm.model.response.AuthenticationSuccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/")
public class EventController {

    @Autowired
    private EventRepository eventRepository;

//    @GetMapping("/events")
//    public ResponseEntity<?> displayAllEvents(@RequestBody Event event) {
//        return new ResponseEntity<>()
////        return "/events";
//    }

//    @GetMapping("/event")
//    public String displayEventPage() {
//
//        return "/event";
//    }


    @PostMapping("/create")
    public ResponseEntity<?> createEventForm(@RequestBody Event event) {
        eventRepository.save(event);
        AuthenticationSuccess authenticationSuccess = new AuthenticationSuccess("Success");
        return new ResponseEntity<>(authenticationSuccess, HttpStatus.OK);
    }

    //ResponseEntity represents the whole HTTP response from front end
    //@RequestBody pulls from client side and puts data into Java object (event)
    //new event saved into event repository
    //authenticate user
    //return new event from authenticated user


}
