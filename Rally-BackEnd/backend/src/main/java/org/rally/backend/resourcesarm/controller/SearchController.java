package org.rally.backend.resourcesarm.controller;

import org.rally.backend.resourcesarm.models.Resource;
import org.rally.backend.resourcesarm.models.ResourceData;
import org.rally.backend.resourcesarm.models.data.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static org.rally.backend.resourcesarm.controller.ListController.columnChoices;

@Controller
@RequestMapping("search")
public class SearchController {
    @Autowired
    private ResourceRepository resourceRepository;
    @RequestMapping("")
    public String search(Model model) {
        model.addAttribute("columns", columnChoices);
        return "search";
    }
    @PostMapping("results")
    public String displaySearchResults(Model model, @RequestParam String searchType, @RequestParam String searchTerm){
        Iterable<Resource> resources;
        if (searchTerm.toLowerCase().equals("all") || searchTerm.equals("")){
            resources = resourceRepository.findAll();
        } else resources = ResourceData.findByColumnAndValue(searchType, searchTerm, resourceRepository.findAll());
        model.addAttribute("columns", columnChoices);
        model.addAttribute("title", "Jobs with " + columnChoices.get(searchType) + ": " + searchTerm);
        model.addAttribute("resources", resources);
        return "search";
        }
    }

