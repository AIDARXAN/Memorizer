package com.memorizer.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.memorizer.R;

import androidx.appcompat.app.AppCompatActivity;

public class AddWordActivity  extends AppCompatActivity {
    private EditText wordEditText;
    private EditText translationEditText;
    private Button saveButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_word);

        wordEditText = findViewById(R.id.word_edit_text);
        translationEditText = findViewById(R.id.translate_edit_text);
        saveButton = findViewById(R.id.save_button);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String wordString = wordEditText.getText().toString();
                String translationString = translationEditText.getText().toString();

                String msg = "Saved " + wordString + " : " + translationString;
                Toast.makeText(AddWordActivity.this, msg, Toast.LENGTH_SHORT).show();
            }
        });

    }
}
