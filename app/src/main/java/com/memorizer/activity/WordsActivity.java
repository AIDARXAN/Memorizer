package com.memorizer.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.memorizer.R;
import com.memorizer.adapter.WordAdapter;
import com.memorizer.entity.Word;

import java.util.Arrays;
import java.util.List;

public class WordsActivity extends AppCompatActivity {
    private static final int ADD_WORD_REQUEST_CODE = 1001;

    private FloatingActionButton addButton;
    private RecyclerView recyclerView;
    private WordAdapter wordAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addButton = findViewById(R.id.add_button);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WordsActivity.this, AddWordActivity.class);
                startActivityForResult(intent, ADD_WORD_REQUEST_CODE);
            }
        });
        recyclerView = findViewById(R.id.word_recycle_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        wordAdapter = new WordAdapter();
        recyclerView.setAdapter(wordAdapter);

        List<Word> words = getWords();
        wordAdapter.setWords(words);
    }

    private List<Word> getWords(){
        return Arrays.asList(
                new Word("Father", "Ата"),
                new Word("Mother", "Апа"),
                new Word("Brother", "Байке")
        );
    }
}
