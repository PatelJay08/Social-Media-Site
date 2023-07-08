package com.jayptl08.socialmediasite.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;


import com.jayptl08.socialmediasite.model.FollowRelation;


public interface FollowReletionRepository extends JpaRepository<FollowRelation,Integer> {
    
    ArrayList<FollowRelation> findPostByUserId(String userId);

    ArrayList<FollowRelation> findFollowersByFollowingUserId(String followingUserId);

    // boolean exists(FollowRelation followRelation);

    FollowRelation findByUserIdAndFollowingUserId(String userId,String followingUserId);

    boolean deleteByUserIdAndFollowingUserId(String userid,String followingUserId);


}
