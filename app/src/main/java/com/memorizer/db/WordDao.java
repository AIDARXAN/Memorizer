package com.memorizer.db;

import com.memorizer.entity.Word;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface WordDao {

    @Insert
    void insert(Word word);

    @Query("SELECT * FROM Word")
    List<Word> getWords();
}
