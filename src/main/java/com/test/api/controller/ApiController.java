package com.test.api.controller;

import com.test.api.entities.UserEntity;
import com.test.api.models.Message;
import com.test.api.models.User;
import com.test.api.repositories.UserRepository;
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

    private final UserRepository userRepository;

    @Autowired
    public ApiController(UserRepository userRepository) {
        this.userRepository = userRepository;
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

        LocalDateTime now = LocalDateTime.now();

        UserEntity userEntity = new UserEntity();
        userEntity.setName(user.getName());
        userEntity.setEmail(user.getEmail());
        userEntity.setPassword(user.getPassword());
        userEntity.setPhones("");
        userEntity.setCreated(now);
        userEntity.setModified(now);
        userEntity.setLastLogin(now);
        userEntity.setActive(true);

        userRepository.save(userEntity);

        return new ResponseEntity<>(new Message(""), HttpStatus.OK);
    }
}
