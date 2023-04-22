package org.rally.backend.userprofilearm.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
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
    private static int userSessionId = 0;
    private static final String userSessionKey = "user";


    @GetMapping("/currentUser")
    public ResponseEntity<?> getUserFromSession(HttpSession session) {

        if (userSessionId == 0) {
            return null;
        }

        Optional<UserEntity> user = userRepository.findById(userSessionId);

        if (user.isEmpty()) {
            return null;
        }

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    private static void setUserInSession(HttpSession session, UserEntity userEntity) {
        session.setAttribute(userSessionKey, userEntity.getId());
    }

    @PostMapping("/register")
    public ResponseEntity<?> processRegistrationForm(@RequestBody RegisterDTO registerDTO, HttpServletRequest request) {

        UserEntity existingUser = userRepository.findByUserName(registerDTO.getUserName());

        if (existingUser != null) {
            AuthenticationFailure authenticationFailure = new AuthenticationFailure("That username is taken.");
            return new ResponseEntity<>(authenticationFailure, HttpStatus.OK);
        }

        String password = registerDTO.getPassword();
        String verifyPassword = registerDTO.getVerifyPassword();
        if (!password.equals(verifyPassword)) {
            AuthenticationFailure authenticationFailure = new AuthenticationFailure("Passwords do not match.");
            return new ResponseEntity<>(authenticationFailure, HttpStatus.OK);
        }

        UserEntity newUser = new UserEntity(registerDTO.getUserName(), registerDTO.getPassword());
        Role roles = roleRepository.findByName("USER").get();
        newUser.setRoles(Collections.singletonList(roles));

        userRepository.save(newUser);
        setUserInSession(request.getSession(), newUser);
        AuthenticationSuccess authenticationSuccess = new AuthenticationSuccess("User successfully registered.");

        return new ResponseEntity<>(authenticationSuccess, HttpStatus.OK);

    }
    @PostMapping("/login")
    public ResponseEntity<?> processLoginForm(@RequestBody LoginDTO loginDTO,
                                              Errors errors, HttpServletRequest request,
                                              Model model) {

        UserEntity theUser = userRepository.findByUserName(loginDTO.getUserName());

        if (theUser == null) {
            AuthenticationFailure authenticationFailure = new AuthenticationFailure("Username does not exist.");
            return new ResponseEntity<>(authenticationFailure, HttpStatus.OK);
        }

        String password = loginDTO.getPassword();

        if (!theUser.isMatchingPassword(password)) {
            AuthenticationFailure authenticationFailure = new AuthenticationFailure("Incorrect password.");
            return new ResponseEntity<>(authenticationFailure, HttpStatus.OK);
        }

        setUserInSession(request.getSession(), theUser);
        userSessionId = theUser.getId();
        AuthenticationSuccess authenticationSuccess = new AuthenticationSuccess("User logged in and session created");

        return new ResponseEntity<>(theUser, HttpStatus.OK);
    }

    @GetMapping("/logout")
    public ResponseEntity<?> logout(HttpServletRequest request){
        request.getSession().invalidate();
        AuthenticationFailure authenticationFailure = new AuthenticationFailure("User logged out.");
        return new ResponseEntity<>(authenticationFailure, HttpStatus.OK);
    }

}