package com.memorizer.db;

import com.memorizer.entity.Word;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface WordDao {

    @Insert
    void insert(Word word);

    @Query("SELECT * FROM Word WHERE type = 1")
    List<Word> getWords();

    @Delete
    void delete(Word word);

    @Query("DELETE FROM Word")
    void deleteAll();

    @Update
    void update(Word word);
}
