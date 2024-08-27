package org.ogleh.userservice.controllers;

import lombok.RequiredArgsConstructor;
import org.ogleh.userservice.dao.UserRequest;
import org.ogleh.userservice.dto.UsersDto;
import org.ogleh.userservice.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @PostMapping("/")
    public ResponseEntity<?>createUser(@RequestBody UserRequest request) {
        userService.createUser(request);
        return ResponseEntity.status(HttpStatus.CREATED).body("successfully created user");
    }



    @GetMapping("/{userID}")
    public UsersDto getUser(@PathVariable("userID") int userID) {
        return userService.getUser(userID);
    }
}
