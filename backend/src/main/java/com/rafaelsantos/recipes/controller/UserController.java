package com.rafaelsantos.recipes.controller;

import com.rafaelsantos.recipes.models.User;
import com.rafaelsantos.recipes.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/users/{userId}")
    public Optional<User> findUserById(@PathVariable Long userId){
       return userRepository.findById(userId);
    }


    @PostMapping("/users")
    public User createUser(@RequestBody User user) throws Exception {

        User userExists = userRepository.findByEmail(user.getEmail());
        if(userExists != null){
            throw new Exception("User exists with this email" + user.getEmail());
        }

        return userRepository.save(user);
    }

    @DeleteMapping("/users/{userId}")
    public String deleteUser(@PathVariable Long userId) {

       userRepository.deleteById(userId);

        return "User deleted successfully";
    }



   /* public User findByEmail(String email) throws Exception{
        User user = userRepository.findByEmail(email);
        if(user == null){
            throw new Exception("User not found with email" + email);
        }
        return user;
    }*/
}
