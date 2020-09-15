package com.example.trackpupilsdatabaseroom;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trackpupilsdatabaseroom.DataModel.DataConverter;
import com.example.trackpupilsdatabaseroom.DataModel.Word;

import java.util.List;


public class WordRecycler extends RecyclerView.Adapter<WordViewHolder> {

    List<Word> data;
    public WordRecycler (List<Word> words){
        data = words;
    }
    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i){
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(
                R.layout.word_item_layout,
                viewGroup,
                false
        );
        return new WordViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WordViewHolder wordViewHolder, int i){
        Word word = data.get(i);
        wordViewHolder.imageView.setImageBitmap(DataConverter.convertByteArray2Image(word.getImage()));
        wordViewHolder.wordText.setText(word.getWord());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


}
