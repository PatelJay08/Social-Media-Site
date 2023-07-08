package com.jayptl08.socialmediasite.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jayptl08.socialmediasite.model.FollowRelation;
import com.jayptl08.socialmediasite.service.FollowReletionService;

@RestController
@RequestMapping("/follow")
public class FollowReletionController {

    @Autowired
    FollowReletionService followReletionService;

    @PostMapping("")
    private FollowRelation addNewFollowRelation(@RequestBody FollowRelation followRelation){
        return followReletionService.addNewReletion(followRelation); 
    }

    @GetMapping("/{userId}")
    private ArrayList<FollowRelation> getAllFollowings(@PathVariable String userId){
        return followReletionService.findUsersByUserId(userId);
    }

    @GetMapping("followers/{followingUserId}")
    private ArrayList<FollowRelation> getAllFollowers(@PathVariable String followingUserId){
        return followReletionService.findUsersByFollowingId(followingUserId);
    }

    @PostMapping("isfollowing")
    private boolean isFollowing(@RequestBody FollowRelation followRelation){
        return followReletionService.isFollowing(followRelation);
    }

    @PostMapping("deleteRelation")
    private boolean deleteRelation(@RequestBody FollowRelation followRelation){
        return followReletionService.deleteRelation(followRelation);
    }

}
