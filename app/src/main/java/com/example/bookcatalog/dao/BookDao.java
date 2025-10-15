package com.example.bookcatalog.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.bookcatalog.model.Book;

import java.util.List;

@Dao
public interface BookDao {

    @Insert
    void insert(Book book);

    @Query("SELECT * FROM books")
    LiveData<List<Book>> getAllBooks();
}
