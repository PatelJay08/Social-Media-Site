package com.jayptl08.socialmediasite.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jayptl08.socialmediasite.model.Comments;
import com.jayptl08.socialmediasite.repository.CommentsRepository;

@Service
public class CommentsService {

    @Autowired
    CommentsRepository commentsRepository;

    @Autowired
    UsersService usersService;

    public Comments saveComments(Comments comments) {
        return commentsRepository.save(comments);
    }

    public ArrayList<Comments> getAllCommentsForPost(String postId) {
        ArrayList<Comments> postsList = commentsRepository.findBypostId(postId);

        for (int i = 0; i < postsList.size(); i++) {
            Comments comments = postsList.get(i);
            comments.setUserName(usersService.findUsersByUserId(comments.getUserId()).getUserName());
        }

        // Collections.sort(postsList, (a, b) -> b.getId() - a.getId());

        return postsList;
    }

}
