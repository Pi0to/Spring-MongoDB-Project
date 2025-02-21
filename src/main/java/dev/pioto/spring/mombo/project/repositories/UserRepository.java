package dev.pioto.spring.mombo.project.repositories;

import dev.pioto.spring.mombo.project.models.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
}
