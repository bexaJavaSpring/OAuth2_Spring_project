package com.example.oauth2_spring_project.controller;

import com.example.oauth2_spring_project.entity.User;
import com.example.oauth2_spring_project.exception.ResourceNotFoundException;
import com.example.oauth2_spring_project.repository.UserRepository;
import com.example.oauth2_spring_project.security.CurrentUser;
import com.example.oauth2_spring_project.security.UserPrincipal;
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
