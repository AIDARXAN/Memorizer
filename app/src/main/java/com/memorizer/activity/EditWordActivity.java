package com.memorizer.activity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.memorizer.App;
import com.memorizer.R;
import com.memorizer.db.AppDatabase;
import com.memorizer.entity.Word;

import androidx.appcompat.app.AppCompatActivity;

public class EditWordActivity extends AppCompatActivity {
    private EditText wordEditText;
    private EditText translationEditText;
    private EditText transcriptionEditText;
    private Button saveButton;
    private AppDatabase appDatabase = App.getAppDatabase();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_word);

        wordEditText = findViewById(R.id.word_edit_text);
        translationEditText = findViewById(R.id.translate_edit_text);
        transcriptionEditText = findViewById(R.id.transcript_edit_text);
        saveButton = findViewById(R.id.save_button);

        Intent intent = getIntent();
        wordEditText.setText(intent.getStringExtra("word"));
        translationEditText.setText(intent.getStringExtra("translation"));
        transcriptionEditText.setText(intent.getStringExtra("transcription"));

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String wordString = wordEditText.getText().toString();
                String translationString = translationEditText.getText().toString();
                String transcriptionString = transcriptionEditText.getText().toString();
                Word word = new Word(wordString, translationString, transcriptionString, 1);
                saveToDatabase(word);
            }
        });

    }

    private void saveToDatabase(final Word word){
        new AsyncTask<Void, Void, Void>(){

            @Override
            protected Void doInBackground(Void... voids) {
                appDatabase.getWordDao().update(word);
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                setResult(RESULT_OK);
                finish();
            }
        }.execute();
    }
}