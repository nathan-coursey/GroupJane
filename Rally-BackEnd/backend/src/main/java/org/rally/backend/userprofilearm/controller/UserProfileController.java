package org.rally.backend.userprofilearm.controller;

import org.rally.backend.userprofilearm.model.*;
import org.rally.backend.userprofilearm.model.dto.DirectMessageDTO;
import org.rally.backend.userprofilearm.model.dto.UserInfoDTO;
import org.rally.backend.userprofilearm.repository.DirectMessageRepository;
import org.rally.backend.userprofilearm.repository.RoleRepository;
import org.rally.backend.userprofilearm.repository.UserInformationRepository;
import org.rally.backend.userprofilearm.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping(value = "/user")
public class UserProfileController {

    UserRepository userRepository;
    UserInformationRepository userInformationRepository;
    RoleRepository roleRepository;
    DirectMessageRepository directMessageRepository;


    @Autowired
    public UserProfileController(UserRepository userRepository,
                                 RoleRepository roleRepository,
                                 UserInformationRepository userInformationRepository,
                                 DirectMessageRepository directMessageRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.userInformationRepository = userInformationRepository;
        this.directMessageRepository = directMessageRepository;
    }

    /** GET REQUEST **/
    /** GET REQUEST **/
    /** GET REQUEST **/

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

    @GetMapping("/getActiveUserDirectMessageHistory/{id}")
    public AllMainUserDMs activeUserDirectMessageHistory(@PathVariable int id) {
        List<DirectMessage> sent = new ArrayList<>();
        List<DirectMessage> received = new ArrayList<>();
        AllMainUserDMs totalHistory;

        for (DirectMessage dm : directMessageRepository.findAll()) {
            if (dm.getSentByUserId().equals(id)) {
                sent.add(dm);
            } else if (dm.getReceivedByUserId().equals(id)) {
                received.add(dm);
            }
        }

        // How do I organize these into threads? Maybe a thread class that holds the dms from that user?

        totalHistory = new AllMainUserDMs(sent, received);

        return totalHistory;
    }


    /** POST REQUEST **/
    /** POST REQUEST **/
    /** POST REQUEST **/

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

    @PostMapping("/sendDirectMessage")
    public ResponseEntity<?> updateUserInformation(@RequestBody DirectMessageDTO directMessageDTO) {

        DirectMessage messageSent = new DirectMessage(directMessageDTO.getReceivedByUserId(),
                                                      directMessageDTO.getReceivedByUserName(),
                                                      directMessageDTO.getSentByUserId(),
                                                      directMessageDTO.getSentByUserName(),
                                                      directMessageDTO.getMessageContent());

        directMessageRepository.save(messageSent);

        return new ResponseEntity<>(messageSent, HttpStatus.OK);

    }


}
