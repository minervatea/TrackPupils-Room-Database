package com.example.trackpupilsdatabaseroom;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class WordViewHolder extends RecyclerView.ViewHolder {
    ImageView imageView;
    TextView wordText;

    public WordViewHolder(@NonNull View itemView){
        super(itemView);
        wordText = itemView.findViewById(R.id.cardName);
        imageView = itemView.findViewById(R.id.cardImage);
    }
}
