package com.bookStore.service;

import com.bookStore.entity.User;

public interface UserService {

    public User saveUser(User user);

    public void removeSessionMessage();

}