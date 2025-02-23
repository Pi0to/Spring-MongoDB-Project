package dev.pioto.spring.mombo.project.services;

import dev.pioto.spring.mombo.project.models.dtos.userDtos.CreateUserDTO;
import dev.pioto.spring.mombo.project.models.entities.User;
import dev.pioto.spring.mombo.project.repositories.UserRepository;
import dev.pioto.spring.mombo.project.services.exceptions.ObjNotFoundException;
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

    public User getUserById(String userId) {

        var user = userRepository
                .findById(userId)
                .orElseThrow(() -> new ObjNotFoundException());


        return user;
    }

    public User insertUser(CreateUserDTO userDTO) {

        return userRepository.insert(userFromDTO(userDTO));
    }

    private User userFromDTO(CreateUserDTO dto){
        return new User (null, dto.name(), dto.email());
    }
}
