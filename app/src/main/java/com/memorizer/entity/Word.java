package com.memorizer.entity;

import java.util.Objects;

public class Word {
    private String word;
    private String translation;

    public Word(String word, String translation) {
        this.word = word;
        this.translation = translation;
    }

    public String getWord() {
        return word;
    }

    public String getTranslation() {
        return translation;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word word1 = (Word) o;
        return word.equals(word1.word) &&
                translation.equals(word1.translation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(word, translation);
    }
}
