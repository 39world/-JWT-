package com.bookstroy.bookback.controller;

import com.bookstroy.bookback.domain.model.User;
import com.bookstroy.bookback.domain.repository.UserRepository;
import com.bookstroy.bookback.exception.ResourceNotFoundException;
import com.bookstroy.bookback.security.CurrentUser;
import com.bookstroy.bookback.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user/me")
    @PreAuthorize("hasRole('USER')")
    public User getCurrentUser(@CurrentUser UserPrincipal userPrincipal) {
        return userRepository.findById(userPrincipal.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userPrincipal.getId()));
    }
}
