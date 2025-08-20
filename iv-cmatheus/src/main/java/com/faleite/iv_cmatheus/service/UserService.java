package com.faleite.iv_cmatheus.service;

import com.faleite.iv_cmatheus.model.UserEntity;
import com.faleite.iv_cmatheus.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public UserEntity registerUser(String username, String password){
        String passCrypto = passwordEncoder.encode(password);
        UserEntity user = new UserEntity(username, passCrypto);
        return  userRepository.save(user);
    }

    public Optional<UserEntity> findUserByUsername(String username){
        return userRepository.findByUsername(username);
    }
}
