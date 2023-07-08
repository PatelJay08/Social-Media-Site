package com.jayptl08.socialmediasite.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class FollowRelation {

    @Id
    @GeneratedValue
    private Integer id;

    private String userId;
    private String followingUserId;

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFollowingUserId() {
        return followingUserId;
    }

    public void setFollowingUserId(String followingUserId) {
        this.followingUserId = followingUserId;
    }

    public FollowRelation() {
    }

    public FollowRelation(Integer id, String userId, String followingUserId) {
        this.id = id;
        this.userId = userId;
        this.followingUserId = followingUserId;
    }

}
