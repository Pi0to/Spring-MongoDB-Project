package dev.pioto.spring.mombo.project.controllers;

import dev.pioto.spring.mombo.project.models.dtos.UserDTO;
import dev.pioto.spring.mombo.project.models.entities.User;
import dev.pioto.spring.mombo.project.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers(){

        var list = userService
                .getAllUsers()
                .stream()
                .map(user -> new UserDTO(user))
                .toList();

        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable("userId") String userId){

    var user = userService.getUserById(userId);

    return ResponseEntity.ok().body(new UserDTO(user));

    }
}
