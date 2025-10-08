package com.example.bookcatalog.model;

/**
 * Model class representing a Book.
 */
public class Book {
    private String title;
    private String author;
    private float rating;

    public Book(String title, String author, float rating) {
        this.title = title;
        this.author = author;
        this.rating = rating;
    }

    public String getTitle() { return title; }

    public String getAuthor() { return author; }

    public float getRating() { return rating; }
}
