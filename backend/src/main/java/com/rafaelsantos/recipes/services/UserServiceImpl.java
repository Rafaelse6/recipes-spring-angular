package com.rafaelsantos.recipes.services;

import com.rafaelsantos.recipes.config.JwtProvider;
import com.rafaelsantos.recipes.models.User;
import com.rafaelsantos.recipes.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtProvider jwtProvider;

    @Override
    public User findUserById(Long userId) throws Exception {
        Optional<User> opt = userRepository.findById(userId);

        if (opt.isPresent()) {
            return opt.get();
        }

        throw new Exception("User not found with id: " + userId);
    }

    @Override
    public User findUserByJwt(String jwt) throws Exception {

        String email = jwtProvider.getEmailFromJwtToken(jwt);
        if (email == null) {
            throw new Exception("Token is invalid");
        }

        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new Exception("User not found with email " + email);
        }
        return user;

    }
}
