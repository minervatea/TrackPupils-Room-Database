package com.example.trackpupilsdatabaseroom.DataModel;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.util.TableInfo;

@Entity(tableName = "Words")
public class Word {
    @PrimaryKey(autoGenerate = true)
    int id;
    @ColumnInfo(name = "Word")
    String word;
    @ColumnInfo(typeAffinity = ColumnInfo.BLOB)
    byte [] image;


    public int getId() {
        return id;
    }

    public String getWord() {
        return word;
    }

    public byte[] getImage() {
        return image;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setWord(String word){
        this.word = word;
    }

    public void setImage(byte[] image){
        this.image = image;
    }
}
