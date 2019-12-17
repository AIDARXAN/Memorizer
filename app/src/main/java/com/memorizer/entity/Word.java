package com.memorizer.entity;

import java.util.Objects;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Word {
    @PrimaryKey
    @NonNull
    private String word;
    private String translation;
    private String transcription;
    private int type;

    public Word(@NonNull String word, String translation, String transcription, int type) {
        this.word = word;
        this.translation = translation;
        this.transcription = transcription;
        this.type = type;
    }

    public String getWord() {
        return word;
    }

    public String getTranslation() {
        return translation;
    }

    public String getTranscription() {
        return transcription;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word word1 = (Word) o;
        return word.equals(word1.word) &&
                translation.equals(word1.translation) && transcription.equals(word1.transcription) && type == word1.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(word, translation, transcription, type);
    }
}
