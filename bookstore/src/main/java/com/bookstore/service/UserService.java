package com.bookstore.service;

import com.bookstore.model.User;
import com.bookstore.web.UserRegistrationDto;

public interface UserService {
    User save(UserRegistrationDto registrationDto);
}
