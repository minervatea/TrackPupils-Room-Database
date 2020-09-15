package com.example.trackpupilsdatabaseroom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.trackpupilsdatabaseroom.DataModel.WordDAO;
import com.example.trackpupilsdatabaseroom.DataModel.WordDatabase;

public class ShowActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    WordDAO wordDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        recyclerView = findViewById(R.id.wordRecyclerView);


        wordDAO = WordDatabase.getDBInstance(this).wordDAO();

        WordRecycler wordRecycler = new WordRecycler(wordDAO.getAllWords());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(wordRecycler);


    }
}