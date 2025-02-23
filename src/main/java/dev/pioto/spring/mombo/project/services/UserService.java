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
                .orElseThrow(ObjNotFoundException::new);


        return user;
    }

    public User insertUser(CreateUserDTO userDTO) {

        return userRepository.insert(userFromDTO(userDTO));
    }

    private User userFromDTO(CreateUserDTO dto){
        return new User (null, dto.name(), dto.email());
    }

    public void deleteUser(String userId) {

        getUserById(userId);

        userRepository.deleteById(userId);
    }

    public void updateUser(String userId, CreateUserDTO userDTO) {

        var user = getUserById(userId);

        updateUserData(user, userDTO);

        userRepository.save(user);
    }

    private void updateUserData(User user, CreateUserDTO userDTO) {

        user.setName(userDTO.name());
        user.setEmail(userDTO.email());
    }
}
