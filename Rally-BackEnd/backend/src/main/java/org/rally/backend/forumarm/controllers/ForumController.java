package org.rally.backend.forumarm.controllers;

import org.rally.backend.forumarm.models.ForumPost;
import org.rally.backend.forumarm.repository.PostRepository;
import org.rally.backend.userprofilearm.model.response.AuthenticationSuccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "/posts")
public class ForumController {
    @Autowired
    PostRepository postRepository;

    @PostMapping
    public ResponseEntity<?> createPost(@RequestBody ForumPost forumPost){
        postRepository.save(forumPost);
        AuthenticationSuccess authenticationSuccess = new AuthenticationSuccess("Success");
        return new ResponseEntity<>(authenticationSuccess, HttpStatus.OK);
    }
}
