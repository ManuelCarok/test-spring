package com.test.api.controller;

import com.test.api.entities.UserEntity;
import com.test.api.models.Message;
import com.test.api.models.User;
import com.test.api.repositories.UserRepository;
import com.test.api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class ApiController {

    private final UserService userService;

    @Autowired
    public ApiController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public ResponseEntity<Object> init() {
        String message = "Bienvenidos a la API";
        return new ResponseEntity<>(new Message(message), HttpStatus.OK);
    }

    @PostMapping("user")
    public ResponseEntity<Object> newUser(@Valid @RequestBody User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String errorMessage = bindingResult.getFieldError().getDefaultMessage();
            return new ResponseEntity<>(new Message(errorMessage), HttpStatus.BAD_REQUEST);
        }

        if(userService.existsByEmail(user.getEmail())) {
            return new ResponseEntity<>(new Message("El correo ya registrado"), HttpStatus.BAD_REQUEST);
        }

        UserEntity userEntity = userService.saveUser(user);

        return new ResponseEntity<>(new Message(""), HttpStatus.OK);
    }
}
