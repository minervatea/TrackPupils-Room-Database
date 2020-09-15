package com.example.trackpupilsdatabaseroom.DataModel;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

// Data Access Object
@Dao
public interface WordDAO {
    @Query("Select * from Words")
    List<Word> getAllWords();

    @Insert
    void insertWord(Word word);

    @Update
    void updateWord(Word word);

    @Delete
    void deleteWord(Word word);



}
