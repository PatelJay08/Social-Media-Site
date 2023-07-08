package com.jayptl08.socialmediasite.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jayptl08.socialmediasite.model.Posts;
import com.jayptl08.socialmediasite.service.PostsService;

@RestController
@RequestMapping("/posts")
public class PostsController {
    
    @Autowired
    PostsService postsService;

    @GetMapping("")
    private ArrayList<Posts> getPosts(){
        return postsService.getAllPosts();
    }
    @GetMapping("/{userId}")
    private ArrayList<Posts> getFollowPosts(@PathVariable String userId){
        return postsService.getFollowPosts(userId);
    }

    @GetMapping("/myposts/{userId}")
    private ArrayList<Posts> getMyPosts(@PathVariable String userId){
        return postsService.findPostsByUserId(userId);
    }

    @PostMapping("")
    private Posts submitPost(@RequestBody Posts posts){
        return postsService.savePosts(posts);
    }

    @PostMapping("/delete")
    private Posts deletePost(@RequestBody Posts post){
        return postsService.deletePost(post);
    }

    @PostMapping("/liked")
    private Posts postLiked(@RequestBody Posts post){
        return postsService.postLiked(post);
    }
    @PostMapping("/disliked")
    private Posts postDisLiked(@RequestBody Posts post){
        return postsService.postDisLiked(post);
    }

}
