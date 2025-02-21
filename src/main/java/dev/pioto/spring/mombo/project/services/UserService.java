package dev.pioto.spring.mombo.project.services;

import dev.pioto.spring.mombo.project.models.entities.User;
import dev.pioto.spring.mombo.project.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers () {

        return userRepository.findAll();
    }
}
