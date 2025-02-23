package dev.pioto.spring.mombo.project.controllers;

import dev.pioto.spring.mombo.project.models.dtos.userDtos.CreateUserDTO;
import dev.pioto.spring.mombo.project.models.dtos.userDtos.UserDTO;
import dev.pioto.spring.mombo.project.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriBuilder;

import java.net.URI;
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

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody CreateUserDTO userDTO){

        var user = userService.insertUser(userDTO);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(user.getUserId())
                .toUri();

        return ResponseEntity.created(uri).body("User created successfully");
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable("userId") String userId){

    var user = userService.getUserById(userId);

    return ResponseEntity.ok().body(new UserDTO(user));

    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable("userId") String userId){

        userService.deleteUser(userId);

        return ResponseEntity.noContent().build();
    }


}
