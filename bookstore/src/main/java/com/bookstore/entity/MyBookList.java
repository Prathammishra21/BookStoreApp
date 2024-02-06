package com.bookstore.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "my_books")
public class MyBookList {
    @Id
    private int id;
    private String name;
    private String author;
    private int edition;
    private String price;
    private String publisher;

    public MyBookList(int id, String name, String author,int edition, String price, String publisher) {
        super();
        this.id = id;
        this.name = name;
        this.author = author;
        this.edition = edition;
        this.price = price;
        this.publisher=publisher;
    }

    public MyBookList() {
        super();
        // TODO Auto-generated constructor stub
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
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

    public int getEdition() {
        return edition;
    }

    public void setEdition(int edition) {
        this.edition = edition;
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

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
}
