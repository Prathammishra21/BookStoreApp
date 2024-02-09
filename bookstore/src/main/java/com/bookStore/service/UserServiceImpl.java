package com.bookStore.service;
import com.bookStore.entity.User;
import com.bookStore.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService{
@Autowired
    private UserRepo userRepo;

@Override
    public User saveUser(User user){
    User newuser = userRepo.save(user);
    return newuser;
    }
}
