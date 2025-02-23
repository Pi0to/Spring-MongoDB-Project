package dev.pioto.spring.mombo.project.models.dtos.userDtos;

import dev.pioto.spring.mombo.project.models.entities.User;

public record UserDTO(String id, String name, String email) {

    public UserDTO {
    }

    public UserDTO(User user){
        this(user.getUserId(), user.getName(), user.getEmail());
    }
}
