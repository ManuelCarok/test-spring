package com.test.api.controller;

import com.test.api.models.Message;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class ApiController {

    @GetMapping("/")
    public ResponseEntity<Object> init() {
        String message = "Bienvenidos a la API";
        return new ResponseEntity<>(new Message(message), HttpStatus.OK);
    }
}
