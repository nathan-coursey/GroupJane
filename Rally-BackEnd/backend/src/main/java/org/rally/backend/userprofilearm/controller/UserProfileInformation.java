package org.rally.backend.userprofilearm.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.rally.backend.userprofilearm.model.UserEntity;
import org.rally.backend.userprofilearm.repository.RoleRepository;
import org.rally.backend.userprofilearm.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/user")
public class UserProfileInformation {

    UserRepository userRepository;

    RoleRepository roleRepository;

    @Autowired
    public UserProfileInformation(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @GetMapping("/search")
    public List<UserEntity> displayAllUsers() {
        return this.userRepository.findAll();
    }

}
