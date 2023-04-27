package org.rally.backend.userprofilearm.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.rally.backend.userprofilearm.model.UserEntity;
import org.rally.backend.userprofilearm.model.UserInformation;
import org.rally.backend.userprofilearm.model.dto.RegisterDTO;
import org.rally.backend.userprofilearm.model.dto.SearchUserDTO;
import org.rally.backend.userprofilearm.model.dto.UserInfoDTO;
import org.rally.backend.userprofilearm.model.response.AuthenticationSuccess;
import org.rally.backend.userprofilearm.repository.RoleRepository;
import org.rally.backend.userprofilearm.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/user")
public class UserProfileController {

    UserRepository userRepository;

    RoleRepository roleRepository;

    @Autowired
    public UserProfileController(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @GetMapping("/search")
    public List<UserEntity> displayAllUsers() {
        return this.userRepository.findAll();
    }

    @GetMapping("/search/this")
    public UserEntity displayUser(@Valid SearchUserDTO searchUserDTO) {
        /** this doesn't work yet **/
        System.out.println(searchUserDTO.getUserName());
        return this.userRepository.findByUserName(searchUserDTO.getUserName());
    }

    @PostMapping("/update-user-information")
    public ResponseEntity<?> updateUserInformation(@RequestBody UserInfoDTO userInfoDTO, HttpServletRequest request) {

        UserEntity targetUser = userRepository.findByUserName(userInfoDTO.getUserName());

        String firstName = userInfoDTO.getFirstName();
        String lastName = userInfoDTO.getLastName();

        /** NOTE: find user by id and save to UserInformation **/

        AuthenticationSuccess authenticationSuccess = new AuthenticationSuccess("user info added");

        return new ResponseEntity<>(authenticationSuccess, HttpStatus.OK);

    }


}
