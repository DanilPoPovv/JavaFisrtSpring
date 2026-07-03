package org.example.taskmanager.Service;

import org.example.taskmanager.Repository.UserRepository;
import org.example.taskmanager.model.User;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final JwtService jwtService;
    private final UserRepository userRepository;


    public AuthService(JwtService jwtService, UserRepository userRepository) {
        this.jwtService = jwtService;
        this.userRepository = userRepository;
    }

    public String login(String username, String password) {
        var user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if(!user.getPassword().equals(password)) {
            throw new RuntimeException("Wrong password");
        }
        return jwtService.generateJwtToken(username);
    }
    public void createUser(String userName, String password) {
        if(userRepository.existsByUsername(userName)){
            throw new RuntimeException("User already exists");
        }
        var user = new User(userName,password);
        userRepository.save(user);
    }
}
