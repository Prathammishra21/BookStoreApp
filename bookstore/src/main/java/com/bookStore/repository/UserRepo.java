package com.bookStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookStore.entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {

    public User findByEmail(String emaill);

}