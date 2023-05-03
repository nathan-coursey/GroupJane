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
    ForumPostRepository forumPostRepository;

    @GetMapping("/Posts")
    public ResponseEntity<?>getForumPosts(){
        return new ResponseEntity<>(forumPostRepository.findAll(), HttpStatus.OK);
    }
    @PostMapping("/Posts")
    public ResponseEntity<?>createForumPost(@RequestBody ForumPostDTO forumPostDTO){
        ForumPosts forumPost = new ForumPosts(forumPostDTO.getTitle(), forumPostDTO.getDescription(), forumPostDTO.getCategory());
        forumPost.setUserEntity(userRepository.findByUserName(forumPostDTO.getUsername()));
        forumPostRepository.save(forumPost);
        AuthenticationSuccess authenticationSuccess = new AuthenticationSuccess("Success");
        return new ResponseEntity<>(authenticationSuccess, HttpStatus.OK);
    }
}
