package org.rally.backend.servicesarm.controller;


import org.rally.backend.servicesarm.repository.ServiceCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping(value = "/search")
public class SearchController {

    @Autowired
    private ServiceCategoryRepository serviceCategoryRepository;


}
