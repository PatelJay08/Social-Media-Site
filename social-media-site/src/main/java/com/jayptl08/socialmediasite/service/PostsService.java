package com.jayptl08.socialmediasite.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jayptl08.socialmediasite.model.Posts;
import com.jayptl08.socialmediasite.repository.PostsRepository;

@Service
public class PostsService {
    
    @Autowired
    PostsRepository postsRepository;

    @Autowired
    UsersService usersService;

    @Autowired
    FollowReletionService followReletionService;

    public Posts savePosts(Posts posts){
        return postsRepository.save(posts);
    }

    public Posts deletePost(Posts posts){
        postsRepository.delete(posts);
        return null; 
    }

    public ArrayList<Posts> getAllPosts(){
        ArrayList<Posts> postsList = postsRepository.findAll();

        for(int i = 0; i<postsList.size();i++){
            Posts postItem = postsList.get(i);
            postItem.setUserName(usersService.findUsersByUserId(postItem.getUserId()).getUserName());
        }

        Collections.sort(postsList,(a,b)->b.getId()-a.getId());

        return postsList;
    }
    public ArrayList<Posts> getFollowPosts(String userId){

        ArrayList<Posts> postsList = postsRepository.findAll();
        
        Predicate<? super Posts> predicate = postsLis -> postsLis.getUserId().equals(followReletionService.findUsersByUserId(userId).iterator().next().getFollowingUserId());
        
        ArrayList<Posts> pos =  (ArrayList<Posts>) postsList.stream().filter(predicate).collect(Collectors.toList());

        for(int i = 0; i<pos.size();i++){
            Posts postItem = pos.get(i);
            postItem.setUserName(usersService.findUsersByUserId(postItem.getUserId()).getUserName());
        }
        
        Collections.sort(pos,(a,b)->b.getId()-a.getId());
        
        return pos;
    }
    
    public ArrayList<Posts> findPostsByUserId(String userId){

        ArrayList<Posts> postsList = postsRepository.findPostsByUserId(userId);

        for(int i = 0; i<postsList.size();i++){
            Posts postItem = postsList.get(i);
            postItem.setUserName(usersService.findUsersByUserId(postItem.getUserId()).getUserName());
        }

        Collections.sort(postsList,(a,b)->b.getId()-a.getId());

        return postsList;
    }

    // Predicate<? super Posts> predicate = postsLis -> postsLis.getUserId().equals(followReletionService.findUsersByUserId(userId).get(0).getFollowingUserId());

    public Posts postLiked(Posts posts){
        Posts posts1 = postsRepository.findByPostId(posts.getPostId());
        int likes = posts1.getLikeCount();
        likes++;
        posts1.setLikeCount(likes);
        return postsRepository.save(posts1);
    }
    public Posts postDisLiked(Posts posts){
        Posts posts1 = postsRepository.findByPostId(posts.getPostId());
        int likes = posts1.getLikeCount();
        likes--;
        posts1.setLikeCount(likes);
        return postsRepository.save(posts1);
    }

    
}

// postItem.setUserName(usersService.findUsersByUserId(postItem.getUserId()).getUserName());