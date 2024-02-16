package com.bookStore.repository;

import com.bookStore.entity.Book;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer>  {

    public List<Book> findByNameContainingAndUser(String name, User user);

}