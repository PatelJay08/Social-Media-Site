package com.jayptl08.socialmediasite.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jayptl08.socialmediasite.model.Comments;

public interface CommentsRepository extends JpaRepository<Comments,Integer> {
    
    ArrayList<Comments> findBypostId(String postId);

}
