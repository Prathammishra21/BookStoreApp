package com.bookStore.config;

import com.bookStore.entity.User;
import com.bookStore.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
@Component
public class CustomUserDetailsService implements UserDetailsService {
@Autowired
private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        User user =  userRepo.findByEmail(username);

        if(user == null){
            throw new UsernameNotFoundException("User not found");
        }else {
            return new CustomUser(user);
        }
    }
}
