package org.example.taskmanager.controller;

import org.example.taskmanager.Service.AuthService;
import org.example.taskmanager.request.CreateUserRequest;
import org.example.taskmanager.request.UserLoginRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class UserController {
    private final AuthService authService;

    public UserController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("createUser")
    public void createUser(@RequestBody CreateUserRequest createUserRequest){
        authService.createUser(createUserRequest.getUsername(),createUserRequest.getPassword());
    }
    @PostMapping("login")
    public String login(@RequestBody UserLoginRequest loginRequest){
        return authService.login(loginRequest.getUsername(), loginRequest.getPassword());
    }
}
