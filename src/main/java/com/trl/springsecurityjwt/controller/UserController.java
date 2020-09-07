package com.trl.springsecurityjwt.controller;

import com.trl.springsecurityjwt.controller.dto.AuthenticationRequest;
import com.trl.springsecurityjwt.controller.dto.AuthenticationResponse;
import com.trl.springsecurityjwt.controller.dto.UserDTO;
import com.trl.springsecurityjwt.service.UserService;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(
            path = "/authentication",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AuthenticationResponse> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        ResponseEntity<AuthenticationResponse> response = null;

        AuthenticationResponse authenticationToken = userService.createAuthenticationToken(authenticationRequest);

        response = ResponseEntity.ok(authenticationToken);

        return response;
    }

    @GetMapping(
            path = "/hello",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String greetingUser_2() {

        return "Hello User !!!";
    }

    @GetMapping(
            path = "users/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> getUser(@PathVariable Long id) {
        ResponseEntity<UserDTO> response = null;

        UserDTO resultService = userService.getUser(id);

        response = ResponseEntity.ok(resultService);

        return response;
    }

    @GetMapping(
            path = "/user",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> greetingUser() {
        ResponseEntity<String> response = null;

        String str = "Welcome User !!!";

        response = ResponseEntity.ok(str);

        return response;
    }

    @GetMapping(
            path = "/admin",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> greetingAdmin() {
        ResponseEntity<String> response = null;

        String str = "Welcome Admin !!!";

        response = ResponseEntity.ok(str);

        return response;
    }
}
