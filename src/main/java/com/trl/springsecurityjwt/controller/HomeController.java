package com.trl.springsecurityjwt.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping(
            path = "/",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> greetingAll() {
        ResponseEntity<String> response = null;

        String str = "Welcome !!!";

        response = ResponseEntity.ok(str);

        return response;
    }
}