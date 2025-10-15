package com.example.bookcatalog.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.bookcatalog.dao.BookDao;
import com.example.bookcatalog.database.BookDatabase;
import com.example.bookcatalog.model.Book;

import java.util.List;
import java.util.concurrent.Executors;

public class BookViewModel extends AndroidViewModel {

    private BookDao bookDao;
    public LiveData<List<Book>> allBooks;

    public BookViewModel(@NonNull Application application) {
        super(application);
        BookDatabase db = BookDatabase.getInstance(application);
        bookDao = db.bookDao();
        allBooks = bookDao.getAllBooks();
    }

    public void insert(Book book) {
        Executors.newSingleThreadExecutor().execute(() -> bookDao.insert(book));
    }
}
