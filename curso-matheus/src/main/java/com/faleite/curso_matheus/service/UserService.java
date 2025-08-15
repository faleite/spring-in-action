package com.faleite.curso_matheus.service;

import com.faleite.curso_matheus.model.UserModel;
import com.faleite.curso_matheus.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public UserModel registerUser(String username, String password){
        String passCrypt = passwordEncoder.encode(password);
        UserModel user = new UserModel(username, passCrypt);
        return userRepository.save(user);
    }

    public Optional<UserModel> getUserByUsername(String username){
        return userRepository.findByUsername(username);
    }
}
