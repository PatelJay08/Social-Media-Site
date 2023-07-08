package com.jayptl08.socialmediasite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jayptl08.socialmediasite.model.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {

    Users findUsersByUserId(String userId);
    Users findUserByUserName(String userName);
    
}
