package com.webraise.ManageUsersAndSubscriptions.controller;

import com.webraise.ManageUsersAndSubscriptions.model.User;
import com.webraise.ManageUsersAndSubscriptions.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/users")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public User createUser(@RequestBody User user) {
        logger.info("Creating user: {}", user);
        return userRepository.save(user);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        logger.info("Retrieving user with id: {}", id);
        Optional<User> user = userRepository.findById(id);
        return user.map(ResponseEntity::ok).orElseGet(() -> {
            logger.warn("User with id {} not found", id);
            return ResponseEntity.notFound().build();
        });
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User userDetails) {
        logger.info("Updating user with id: {}", id);
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            User updatedUser = user.get();
            updatedUser.setName(userDetails.getName());
            logger.info("User updated: {}", updatedUser);
            return ResponseEntity.ok(userRepository.save(updatedUser));
        }
        logger.warn("User with id {} not found for update", id);
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        logger.info("Deleting user with id: {}", id);
        userRepository.deleteById(id);
        logger.info("User with id {} deleted", id);
        return ResponseEntity.noContent().build();
    }
}
