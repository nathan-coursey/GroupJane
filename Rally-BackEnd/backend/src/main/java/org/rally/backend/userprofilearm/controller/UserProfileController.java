package org.rally.backend.userprofilearm.controller;

import org.rally.backend.userprofilearm.exception.AuthenticationFailure;
import org.rally.backend.userprofilearm.model.UserEntity;
import org.rally.backend.userprofilearm.model.UserInformation;
import org.rally.backend.userprofilearm.model.dto.UserInfoDTO;
import org.rally.backend.userprofilearm.model.response.AuthenticationSuccess;
import org.rally.backend.userprofilearm.repository.RoleRepository;
import org.rally.backend.userprofilearm.repository.UserInformationRepository;
import org.rally.backend.userprofilearm.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping(value = "/user")
public class UserProfileController {

    UserRepository userRepository;
    UserInformationRepository userInformationRepository;
    RoleRepository roleRepository;

    @Autowired
    public UserProfileController(UserRepository userRepository,
                                 RoleRepository roleRepository,
                                 UserInformationRepository userInformationRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.userInformationRepository = userInformationRepository;
    }

    @GetMapping("/search")
    public List<UserEntity> displayAllUsers() {
        return this.userRepository.findAll();
    }

    @GetMapping("/searchid/{id}")
    public Optional<UserEntity> displayUser(@PathVariable int id) { return userRepository.findById(id); }

    @GetMapping("/userinfo/{id}")
    public Optional<UserInformation> displayUserInformation(@PathVariable int id) {
        return userInformationRepository.findById((id));
    }

    @GetMapping("/searchUserName/{userName}")
    public  UserEntity searchByUserName(@PathVariable String userName) {
        return userRepository.findByUserName(userName);
    }

    @PostMapping("/update-user-information")
    public ResponseEntity<?> updateUserInformation(@RequestBody UserInfoDTO userInfoDTO) {

        UserEntity targetUser = userRepository.findByUserName(userInfoDTO.getUserName());

        String firstName = userInfoDTO.getFirstName();
        String lastName = userInfoDTO.getLastName();

        UserInformation userInformation = new UserInformation(targetUser, firstName, lastName);

        userInformationRepository.save(userInformation);

        AuthenticationSuccess authenticationSuccess = new AuthenticationSuccess("user info added");

        return new ResponseEntity<>(authenticationSuccess, HttpStatus.OK);

    }


}
