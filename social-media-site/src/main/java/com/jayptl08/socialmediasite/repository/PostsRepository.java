package com.jayptl08.socialmediasite.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jayptl08.socialmediasite.model.Posts;


public interface PostsRepository extends JpaRepository<Posts,Integer> {
    
    ArrayList<Posts> findAll();

    Posts findByPostId(String postId);

    ArrayList<Posts> findPostsByUserId(String userId);

}
