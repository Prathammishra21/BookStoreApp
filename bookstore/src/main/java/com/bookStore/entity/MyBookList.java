package com.bookStore.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "mybooks")
public class MyBookList {

    @Id
    private int id;
    private String name;
    private String author;
    private String edition;
    private String price;
    private String publisher;

    public MyBookList() {
        super();
        // TODO Auto-generated constructor stub
    }

    public MyBookList(int id, String name, String author, String edition, String price, String publisher) {
        super();
        this.id = id;
        this.name = name;
        this.author = author;
        this.edition = edition;
        this.price = price;
        this.publisher = publisher;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}