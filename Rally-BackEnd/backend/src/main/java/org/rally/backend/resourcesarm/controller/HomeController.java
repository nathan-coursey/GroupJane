package org.rally.backend.resourcesarm.controller;

import jakarta.validation.Valid;
import org.rally.backend.resourcesarm.models.Category;
import org.rally.backend.resourcesarm.models.Resource;
import org.rally.backend.resourcesarm.models.data.CategoryRepository;
import org.rally.backend.resourcesarm.models.data.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "https://localhost:4200", maxAge = 3600)
@RestController
public class HomeController {
    @Autowired
    private ResourceRepository resourceRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @RequestMapping("")
    public String index(Model model){
        model.addAttribute("title", "My Resources");
        List resources = (List<Resource>) resourceRepository.findAll();
        model.addAttribute("resources", resources);
        return "index";
    }
    @GetMapping("add")
    public String displayAddResourceForm(Model model) {
        model.addAttribute("title", "Add Resource");
        model.addAttribute(new Resource());
        List categories = (List<Category>) categoryRepository.findAll();
        model.addAttribute("categories", categoryRepository.findAll());
        return "add";
    }
    @PostMapping("add")
    public String processAddResourceForm(@ModelAttribute @Valid Resource newResource, Errors errors, Model model, @RequestParam int categoryId) {
        if (errors.hasErrors()){
            model.addAttribute("title", "Add Resource");
            List categories = (List<Category>) categoryRepository.findAll();
            model.addAttribute("categories", categories);
            return "add";
        }
        Optional<Category> optCategory = categoryRepository.findById(categoryId);
        if (optCategory.isPresent()) {
            Category category = optCategory.get();
            newResource.setCategory(category);
            resourceRepository.save(newResource);
        }
            return "redirect:./";
    }
    @GetMapping("view/{resourceID}")
    public String displayViewResource(Model model, @PathVariable int resourceId) {
        Optional<Resource> optResource = resourceRepository.findById(resourceId);
        if(optResource.isPresent()) {
            Resource resource = (Resource) optResource.get();
            model.addAttribute("resource", resource);
            return "view";
        }
        else {
            return "redirect:./";
        }
    }
}
