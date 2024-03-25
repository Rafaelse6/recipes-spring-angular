package com.rafaelsantos.recipes.services;

import com.rafaelsantos.recipes.models.User;
import com.rafaelsantos.recipes.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    public User findUserById(Long userId) throws Exception;
}
