package com.memorizer.db;

import com.memorizer.entity.Word;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = Word.class, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract WordDao getWordDao();
}
