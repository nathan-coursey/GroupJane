package org.rally.backend.userprofilearm.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.rally.backend.userprofilearm.model.UserEntity;
import org.rally.backend.userprofilearm.model.dto.SearchUserDTO;
import org.rally.backend.userprofilearm.repository.RoleRepository;
import org.rally.backend.userprofilearm.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/search/this")
    public ResponseEntity<?> displayUser(@Valid SearchUserDTO searchUserDTO, HttpServletRequest request) {
        UserEntity findUser = this.userRepository.findByUserName(searchUserDTO.getUserName());
        return new ResponseEntity<>(findUser, HttpStatus.OK);
    }

}
