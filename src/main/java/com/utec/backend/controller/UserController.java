package com.utec.backend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClient;

@RestController()
@RequestMapping("/users")
public class UserController {

    private final RestClient restClient;

    public UserController(RestClient restClient) {
        this.restClient = restClient;
    }

    @PostMapping("")
    @ResponseStatus(code = HttpStatus.CREATED)
    public String createUser() {
        return "User created";
    }

    @GetMapping("/{userId}")
    public String getUser(@PathVariable String userId) {
        return String.format("User %s", userId);
    }

    @GetMapping("/{userId}/addresses")
    public String getUserAddress(@PathVariable String userId) {
        return String.format("User %s address", userId);
    }

    @PutMapping("/{userId}")
    public String updateUser(@PathVariable String userId) {
        return String.format("User %s updated", userId);
    }

    @PatchMapping("/{userId}")
    public String patchUser(@PathVariable String userId) {
        return String.format("User %s patched", userId);
    }

    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable String userId) {
        return String.format("User %s deleted", userId);
    }

    @GetMapping("/{userId}/roles")
    public String getUserRoles(@PathVariable String userId) {
        String userResponse = this.restClient
                .get()
                .uri(String.format("http://localhost:8081/users/%s", userId))
                .retrieve()
                .body(String.class);
        return String.format("Response: %s", userResponse);
    }
}
