package com.example.bookcatalog.view;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookcatalog.R;
import com.example.bookcatalog.model.Book;
import com.example.bookcatalog.viewmodel.BookViewModel;

import java.util.List;

/**
 * Main activity that displays the list of books.
 */
public class MainActivity extends AppCompatActivity {
    private BookViewModel bookViewModel;
    private BookAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerViewBooks);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new BookAdapter();
        recyclerView.setAdapter(adapter);

        bookViewModel = new ViewModelProvider(this).get(BookViewModel.class);
        bookViewModel.getBooks().observe(this, adapter::setBooks);
    }
}
