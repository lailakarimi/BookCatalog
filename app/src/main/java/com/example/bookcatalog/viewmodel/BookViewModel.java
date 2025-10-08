package com.example.bookcatalog.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.bookcatalog.model.Book;

import java.util.ArrayList;
import java.util.List;

/**
 * ViewModel that provides book data to the UI.
 */
public class BookViewModel extends ViewModel {
    private final MutableLiveData<List<Book>> bookList = new MutableLiveData<>();

    public BookViewModel() {
        loadBooks();
    }

    private void loadBooks() {
        List<Book> books = new ArrayList<>();
        books.add(new Book("The Great Gatsby", "F. Scott Fitzgerald", 4.3f));
        books.add(new Book("1984", "George Orwell", 4.6f));
        books.add(new Book("To Kill a Mockingbird", "Harper Lee", 4.7f));
        bookList.setValue(books);
    }

    public LiveData<List<Book>> getBooks() {
        return bookList;
    }
}
