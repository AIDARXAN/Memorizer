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

    public Word(@NonNull String word, String translation, String transcription) {
        this.word = word;
        this.translation = translation;
        this.transcription = transcription;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word word1 = (Word) o;
        return word.equals(word1.word) &&
                translation.equals(word1.translation) && transcription.equals(word1.transcription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(word, translation, transcription);
    }
}
