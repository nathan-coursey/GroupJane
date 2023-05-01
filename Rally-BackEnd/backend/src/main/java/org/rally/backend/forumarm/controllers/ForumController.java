package org.rally.backend.forumarm.controllers;

import org.rally.backend.forumarm.models.*;
import org.rally.backend.forumarm.models.dto.ForumPostDTO;
import org.rally.backend.forumarm.repository.*;
import org.rally.backend.userprofilearm.model.UserEntity;
import org.rally.backend.userprofilearm.model.response.AuthenticationSuccess;
import org.rally.backend.userprofilearm.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class ForumController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    CommunityHomePostRepository communityHomePostRepository;
    @Autowired
    IntroductionsPostRepository introductionsPostRepository;
    @Autowired
    ForumTopic1Repository forumTopic1Repository;
    @Autowired
    ForumTopic2Repository forumTopic2Repository;
    @Autowired
    ForumTopic3Repository forumTopic3Repository;

    @GetMapping("/CommunityHome")
    public ResponseEntity<?>getCommunityHomePosts(){
        List<CommunityHome> communityHomePosts = (List<CommunityHome>) communityHomePostRepository.findAll();
        return new ResponseEntity<>(communityHomePosts, HttpStatus.OK);
    }
    @PostMapping("/CommunityHome")
    public ResponseEntity<?>createCommunityHomePosts(@RequestBody ForumPostDTO forumPostDTO){
        CommunityHome communityHomePost = new CommunityHome(forumPostDTO.getTitle(), forumPostDTO.getDescription());
        communityHomePost.setUserEntity(userRepository.findByUserName(forumPostDTO.getUsername()));
        communityHomePostRepository.save(communityHomePost);
        AuthenticationSuccess authenticationSuccess = new AuthenticationSuccess("Success");
        return new ResponseEntity<>(authenticationSuccess, HttpStatus.OK);
    }
    @GetMapping("/Introductions")
    public ResponseEntity<?>getIntroductionsPosts(){
        return new ResponseEntity<>(introductionsPostRepository.findAll(), HttpStatus.OK);
    }
    @PostMapping("/Introductions")
    public ResponseEntity<?>createIntroductionsPosts(@RequestBody ForumPostDTO forumPostDTO){
        Introductions forumPost = new Introductions(forumPostDTO.getTitle(), forumPostDTO.getDescription());
        forumPost.setUserEntity(userRepository.findByUserName(forumPostDTO.getUsername()));
        introductionsPostRepository.save(forumPost);
        AuthenticationSuccess authenticationSuccess = new AuthenticationSuccess("Success");
        return new ResponseEntity<>(authenticationSuccess, HttpStatus.OK);
    }
    @GetMapping("/ForumTopic1")
    public ResponseEntity<?>getForumTopic1Posts(){
        return new ResponseEntity<>(forumTopic1Repository.findAll(), HttpStatus.OK);
    }
    @PostMapping("/ForumTopic1")
    public ResponseEntity<?>createForumTopic1Posts(@RequestBody ForumPostDTO forumPostDTO){
        ForumTopic1 forumPost = new ForumTopic1(forumPostDTO.getTitle(), forumPostDTO.getDescription());
        forumPost.setUserEntity(userRepository.findByUserName(forumPostDTO.getUsername()));
        forumTopic1Repository.save(forumPost);
        AuthenticationSuccess authenticationSuccess = new AuthenticationSuccess("Success");
        return new ResponseEntity<>(authenticationSuccess, HttpStatus.OK);
    }
    @GetMapping("/ForumTopic2")
    public ResponseEntity<?>getForumTopic2Posts(){
        return new ResponseEntity<>(forumTopic2Repository.findAll(), HttpStatus.OK);
    }
    @PostMapping("/ForumTopic2")
    public ResponseEntity<?>createForumTopic2Posts(@RequestBody ForumPostDTO forumPostDTO){
        ForumTopic2 forumPost = new ForumTopic2(forumPostDTO.getTitle(), forumPostDTO.getDescription());
        forumPost.setUserEntity(userRepository.findByUserName(forumPostDTO.getUsername()));
        forumTopic2Repository.save(forumPost);
        AuthenticationSuccess authenticationSuccess = new AuthenticationSuccess("Success");
        return new ResponseEntity<>(authenticationSuccess, HttpStatus.OK);
    }
    @GetMapping("/ForumTopic3")
    public ResponseEntity<?>getForumTopic3Posts(){
        return new ResponseEntity<>(forumTopic3Repository.findAll(), HttpStatus.OK);
    }
    @PostMapping("/ForumTopic3")
    public ResponseEntity<?>createForumTopic3Posts(@RequestBody ForumPostDTO forumPostDTO){
        ForumTopic3 forumPost = new ForumTopic3(forumPostDTO.getTitle(), forumPostDTO.getDescription());
        forumPost.setUserEntity(userRepository.findByUserName(forumPostDTO.getUsername()));
        forumTopic3Repository.save(forumPost);
        AuthenticationSuccess authenticationSuccess = new AuthenticationSuccess("Success");
        return new ResponseEntity<>(authenticationSuccess, HttpStatus.OK);
    }

}
