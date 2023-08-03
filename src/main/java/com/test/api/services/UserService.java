package com.test.api.services;

import com.test.api.entities.UserEntity;
import com.test.api.models.User;

public interface UserService {
    UserEntity saveUser(User user);
    boolean existsByEmail(String email);
}
