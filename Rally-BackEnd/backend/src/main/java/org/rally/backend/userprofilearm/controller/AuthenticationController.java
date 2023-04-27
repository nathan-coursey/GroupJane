package org.rally.backend.userprofilearm.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.rally.backend.userprofilearm.model.UserInformation;
import org.rally.backend.userprofilearm.model.response.AuthenticationSuccess;
import org.rally.backend.userprofilearm.exception.AuthenticationFailure;
import org.rally.backend.userprofilearm.model.Role;
import org.rally.backend.userprofilearm.model.UserEntity;
import org.rally.backend.userprofilearm.model.dto.LoginDTO;
import org.rally.backend.userprofilearm.model.dto.RegisterDTO;
import org.rally.backend.userprofilearm.repository.RoleRepository;
import org.rally.backend.userprofilearm.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping(value = "/api")
public class AuthenticationController {

    UserRepository userRepository;

    RoleRepository roleRepository;

    @Autowired
    public AuthenticationController(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @PostMapping("/register")
    public ResponseEntity<?> processRegistrationForm(@RequestBody RegisterDTO registerDTO, HttpServletRequest request) {

        UserEntity existingUser = userRepository.findByUserName(registerDTO.getUserName());

        if (existingUser != null) {
            AuthenticationFailure authenticationFailure = new AuthenticationFailure("That username is taken");
            return new ResponseEntity<>(authenticationFailure, HttpStatus.OK);
        }

        String password = registerDTO.getPassword();
        String verifyPassword = registerDTO.getVerifyPassword();
        if (!password.equals(verifyPassword)) {
            AuthenticationFailure authenticationFailure = new AuthenticationFailure("Passwords do not match");
            return new ResponseEntity<>(authenticationFailure, HttpStatus.OK);
        }

        UserEntity registerNewUser = new UserEntity((registerDTO.getUserName()), registerDTO.getPassword());


        /** Roles are not enabled for now, leave these rows commented out **/
//        Role roles = roleRepository.findByName("USER").get();
//        registerNewUser.setRoles(Collections.singletonList(roles));

        userRepository.save(registerNewUser);

        AuthenticationSuccess authenticationSuccess = new AuthenticationSuccess("New user successfully registered");

        return new ResponseEntity<>(authenticationSuccess, HttpStatus.OK);

    }


    @PostMapping("/login")
    public ResponseEntity<?> processLoginForm(@RequestBody LoginDTO loginDTO,
                                              Errors errors, HttpServletRequest request,
                                              Model model) {

        UserEntity theUser = userRepository.findByUserName(loginDTO.getUserName());

        if (theUser == null) {
            AuthenticationFailure authenticationFailure = new AuthenticationFailure("Username doesn't exist");
            return new ResponseEntity<>(authenticationFailure, HttpStatus.OK);
        }

        String password = loginDTO.getPassword();

        if (!theUser.isMatchingPassword(password)) {
            AuthenticationFailure authenticationFailure = new AuthenticationFailure("Incorrect password");
            return new ResponseEntity<>(authenticationFailure, HttpStatus.OK);
        }

        return new ResponseEntity<>(theUser, HttpStatus.OK);
    }


}