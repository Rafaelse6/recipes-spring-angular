package com.rafaelsantos.recipes.controller;

import com.rafaelsantos.recipes.models.User;
import com.rafaelsantos.recipes.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/users")
    public User createUser(@RequestBody User user) throws Exception {

        User userExists = userRepository.findByEmail(user.getEmail());
        if(userExists != null){
            throw new Exception("User exists with this email" + user.getEmail());
        }

        return userRepository.save(user);
    }

   /* public User findByEmail(String email) throws Exception{
        User user = userRepository.findByEmail(email);
        if(user == null){
            throw new Exception("User not found with email" + email);
        }
        return user;
    }*/
}
