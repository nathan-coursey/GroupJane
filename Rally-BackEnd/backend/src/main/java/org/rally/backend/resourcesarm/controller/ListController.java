package org.rally.backend.resourcesarm.controller;

import org.rally.backend.resourcesarm.models.data.CategoryRepository;
import org.rally.backend.resourcesarm.models.data.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;

@Controller
@RequestMapping(value = "list")
public class ListController {
    @Autowired
    private ResourceRepository resourceRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    static HashMap<String, String> columnChoices = new HashMap<>();
    public ListController () {
        columnChoices.put("all", "All");
        columnChoices.put("category", "Category");
    }
}
