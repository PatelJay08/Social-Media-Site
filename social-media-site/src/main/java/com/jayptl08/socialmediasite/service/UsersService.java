package com.jayptl08.socialmediasite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jayptl08.socialmediasite.model.Users;
import com.jayptl08.socialmediasite.repository.UsersRepository;

@Service
public class UsersService {
    
    @Autowired
    UsersRepository usersRepository;

    public Users findUsersByUserId(String userId){
       return usersRepository.findUsersByUserId(userId);
    }

    public Users addUsers(Users user){
        return usersRepository.save(user);
    }
    public Users updateUsers(String userId,Users user){
        Users user1 = usersRepository.findUsersByUserId(userId);
        user1.setProfileImage(user.getProfileImage());
        return usersRepository.save(user1);
    }

    public Users findUserByUserName(String userName){
        return usersRepository.findUserByUserName(userName);
    }
}
