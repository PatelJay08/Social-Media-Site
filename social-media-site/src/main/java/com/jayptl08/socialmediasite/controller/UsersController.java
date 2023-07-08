package com.jayptl08.socialmediasite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jayptl08.socialmediasite.model.Users;
import com.jayptl08.socialmediasite.service.UsersService;

@RestController
@RequestMapping("/users")
public class UsersController {
    
    @Autowired
    UsersService usersService;

    @GetMapping("/{userId}")
    private Users getUserMetadataByUserId(@PathVariable String userId){
        return usersService.findUsersByUserId(userId);
    }

    @PutMapping("/{userId}")
    private Users updateUser(@PathVariable String userId, @RequestBody Users users){
        return usersService.updateUsers(userId,users);
    }

    @PostMapping("")
    private Users addNewUser(@RequestBody Users users){
        return usersService.addUsers(users);
    }

    @GetMapping("/search/{userName}")
    private Users searchUser(@PathVariable String userName){
        return usersService.findUserByUserName(userName);
    }

}
