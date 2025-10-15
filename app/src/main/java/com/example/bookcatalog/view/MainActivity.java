package com.example.bookcatalog.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookcatalog.R;
import com.example.bookcatalog.model.Book;
import com.example.bookcatalog.viewmodel.BookViewModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerViewBooks);
        BookAdapter adapter = new BookAdapter();
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        BookViewModel bookViewModel = new ViewModelProvider(this).get(BookViewModel.class);

        // Observe LiveData from Room
        bookViewModel.allBooks.observe(this, books -> {
            adapter.setBooks(books);
        });

        // Insert multiple sample books for demo
        bookViewModel.insert(new Book("Harry Potter", "J.K. Rowling"));
        bookViewModel.insert(new Book("The Hobbit", "J.R.R. Tolkien"));
        bookViewModel.insert(new Book("1984", "George Orwell"));
        bookViewModel.insert(new Book("The Catcher in the Rye", "J.D. Salinger"));
        bookViewModel.insert(new Book("To Kill a Mockingbird", "Harper Lee"));
    }
}
