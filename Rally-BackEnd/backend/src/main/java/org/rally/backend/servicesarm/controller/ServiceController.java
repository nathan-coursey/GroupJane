package org.rally.backend.servicesarm.controller;

import org.rally.backend.servicesarm.model.Service;
import org.rally.backend.userprofilearm.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@CrossOrigin
@RequestMapping(value = "/service")
public class ServiceController {

    @Autowired
    ServiceRepository serviceRepository;

    @PostMapping("/offer")
    public Service processOfferService (Service service) {
            return serviceRepository.save(service);
    }

}
