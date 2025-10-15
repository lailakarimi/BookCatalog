package com.example.bookcatalog.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "books")
public class Book {

    @PrimaryKey(autoGenerate = true)
    public int id;

    public String title;
    public String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }
}
