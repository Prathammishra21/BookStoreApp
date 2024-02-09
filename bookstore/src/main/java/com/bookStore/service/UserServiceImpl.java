package com.bookStore.service;

import com.bookStore.entity.User;
import com.bookStore.repository.UserRepo;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Service
public class UserServiceImpl implements UserService{
@Autowired
    private UserRepo userRepo;

@Override
    public User saveUser(User user){
    User newuser = userRepo.save(user);
    return newuser;
    }

    @Override
    public void removeSessionMessage(){
       HttpSession session =((ServletRequestAttributes)(RequestContextHolder.getRequestAttributes())).getRequest().getSession();
       session.removeAttribute("msg");
    }
}
