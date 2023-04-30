package org.rally.backend.userprofilearm.controller;

import org.rally.backend.userprofilearm.model.UserEntity;
import org.rally.backend.userprofilearm.model.UserInformation;
import org.rally.backend.userprofilearm.model.ViewUserBundle;
import org.rally.backend.userprofilearm.model.dto.UserInfoDTO;
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
@CrossOrigin(origins = "http://localhost:4200/")
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

    @GetMapping("/getViewUserBundleInformation/{userName}")
    public ViewUserBundle getViewUserInformation(@PathVariable String userName) {

        /** call post history and favorites here when ready **/
        UserEntity targetUser = userRepository.findByUserName(userName);
        Optional<UserInformation> targetInformation = userInformationRepository.findById(targetUser.getId());

        return new ViewUserBundle(targetUser, targetInformation);

    }

    @GetMapping("/getUserInformationByUserId/{id}")
    public Optional<UserInformation> searchUserInfoRepositoryByUserId(@PathVariable int id) {

        List<UserInformation> userInformationList = userInformationRepository.findAll();
        Optional<UserInformation> userInformation = Optional.of(new UserInformation());
        for (UserInformation info : userInformationList) {
            if (info.getUserId() == id) {
                userInformation = userInformationRepository.findById(info.getId());
            }
        }

        return userInformation;
    }

    @PostMapping("/update-user-information")
    public ResponseEntity<?> updateUserInformation(@RequestBody UserInfoDTO userInfoDTO) {

        List<UserInformation> userInformationList = userInformationRepository.findAll();

        UserInformation userInformation = new UserInformation(userInfoDTO.getUserId(),
                                                              userInfoDTO.getFirstName(),
                                                              userInfoDTO.getLastName(),
                                                              userInfoDTO.getNeigborhood(),
                                                              userInfoDTO.getCity(),
                                                              userInfoDTO.getState());

        for (UserInformation info : userInformationList) {
            if (info.getUserId() == userInfoDTO.getUserId()) {
                userInformationRepository.deleteById(info.getId());
            }
        }

        userInformationRepository.save(userInformation);

        return new ResponseEntity<>(userInformation, HttpStatus.OK);

    }


}
