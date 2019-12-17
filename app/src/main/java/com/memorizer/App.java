package com.memorizer;

import android.app.Application;

import com.memorizer.db.AppDatabase;

import androidx.room.Room;

public class App extends Application {
    private static AppDatabase appDatabase;

    @Override
    public void onCreate() {
        super.onCreate();

        appDatabase = Room
                .databaseBuilder(this, AppDatabase.class, "app-database2")
                .build();
    }

    public static AppDatabase getAppDatabase() {
        return appDatabase;
    }
}
