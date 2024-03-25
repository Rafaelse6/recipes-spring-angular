package com.rafaelsantos.recipes.repository;

import com.rafaelsantos.recipes.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    public User findByEmail(String email);
}
