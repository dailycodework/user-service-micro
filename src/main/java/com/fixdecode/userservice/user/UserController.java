package com.fixdecode.userservice.user;

import com.fixdecode.userservice.util.ResponseMessage;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController {
    private UserService userService;

    @PostMapping
    public ResponseEntity<ResponseMessage> createUser(@Validated @RequestBody User theUser){
        return ResponseEntity.ok(
                ResponseMessage.builder()
                        .data(Map.of("Users", userService.creatUser(theUser)))
                        .message("A new user was created").
                        status(CREATED).
                        statusCode(CREATED.value()).
                        build());
    }

    @GetMapping
    public ResponseEntity<ResponseMessage> getAllUsers(){
        return ResponseEntity.ok(
                ResponseMessage.builder()
                        .data(Map.of("Users", userService.getAllUsers()))
                        .message("All user found").
                        status(OK).
                        statusCode(OK.value()).
                        build());
    }
    @GetMapping("/{id}")
    public ResponseEntity<ResponseMessage> getUserById(@PathVariable("id") String id){
        return ResponseEntity.ok(
                ResponseMessage.builder()
                        .data(Map.of("Users", userService.getUserById(id)))
                        .message("User found").
                        status(OK).
                        statusCode(OK.value()).
                        build());
    }
    @GetMapping("/user/{id}")
    public ResponseEntity<ResponseMessage> getUserWithDepartment(@PathVariable("id") String userId){
        return ResponseEntity.ok(
                ResponseMessage.builder()
                        .data(Map.of("User data", userService.getUserWithDepartment(userId)))
                        .message("User department found").
                        status(OK).
                        statusCode(OK.value()).
                        build());
    }
}