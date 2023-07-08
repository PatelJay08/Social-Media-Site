package com.jayptl08.socialmediasite.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jayptl08.socialmediasite.model.FollowRelation;
import com.jayptl08.socialmediasite.repository.FollowReletionRepository;

@Service
public class FollowReletionService {

    @Autowired
    FollowReletionRepository followReletionRepository;

    public FollowRelation addNewReletion(FollowRelation followRelation) {
        return followReletionRepository.save(followRelation);
    }

    public ArrayList<FollowRelation> findUsersByUserId(String userid){
        return followReletionRepository.findPostByUserId(userid); 
    }

    public ArrayList<FollowRelation> findUsersByFollowingId(String follwingUserId){
        // followReletionRepository.equals(follwingUserId)
        return followReletionRepository.findFollowersByFollowingUserId(follwingUserId); 
    }

    public boolean isFollowing(FollowRelation followRelation){
        FollowRelation fl1 = followReletionRepository.findByUserIdAndFollowingUserId(followRelation.getUserId(), followRelation.getFollowingUserId());

        if(fl1==null){
            return false;
        }
        return true;
    }
    
    public boolean deleteRelation(FollowRelation followRelation){
        FollowRelation fl1 = followReletionRepository.findByUserIdAndFollowingUserId(followRelation.getUserId(), followRelation.getFollowingUserId());
        followReletionRepository.delete(fl1);
        return true;
    }
    
    // return followReletionRepository.findByUserIdAndFollowingUserId(followRelation.getFollowingUserId(), followRelation.getUserId());
}
