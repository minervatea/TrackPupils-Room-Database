package com.example.trackpupilsdatabaseroom.DataModel;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(
        entities = Word.class,
        version = 1,
        exportSchema = false
)

public abstract class WordDatabase extends RoomDatabase {
        private static WordDatabase wordDB = null;

        public abstract WordDAO wordDAO();

        public static synchronized WordDatabase getDBInstance(Context context){
            if(wordDB == null){
                wordDB = Room.databaseBuilder(
                        context.getApplicationContext(),
                        WordDatabase.class,
                        "word19b2"
                ).allowMainThreadQueries()
                        .build();
            }
            return wordDB;
        }
    }
