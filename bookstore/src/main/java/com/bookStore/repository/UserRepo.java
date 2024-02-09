package com.bookStore.repository;

import com.bookStore.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository <User,Integer>{

}
