package com.esi.avito.controller;


import com.esi.avito.model.Item;
import com.esi.avito.model.User;
import com.esi.avito.service.UserService;
import com.esi.avito.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private ItemService itemService;

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public Optional<User> getUser(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    @GetMapping("/firebase/{firebaseUserId}")
    public ResponseEntity<User> getUserByFirebaseUserId(@PathVariable String firebaseUserId) {
        User user = userService.getUserByFirebaseUserId(firebaseUserId);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/user/{userId}")
    public List<Item> getItemsByUserId(@PathVariable String userId) {
        return itemService.getItemsByFirebaseUserId(userId);
    }

}
