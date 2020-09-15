package com.example.trackpupilsdatabaseroom;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.trackpupilsdatabaseroom.DataModel.DataConverter;
import com.example.trackpupilsdatabaseroom.DataModel.Word;
import com.example.trackpupilsdatabaseroom.DataModel.WordDAO;
import com.example.trackpupilsdatabaseroom.DataModel.WordDatabase;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    Bitmap bmpImage;
    EditText wordText;

    WordDAO wordDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wordText = findViewById(R.id.wordText);
        imageView = findViewById(R.id.wordImage);
        bmpImage = null;

        wordDAO = WordDatabase.getDBInstance(this).wordDAO();
    }

    final int CAMERA_INTENT = 51;

    public void takePicture(View view){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(intent.resolveActivity(getPackageManager()) != null){
            startActivityForResult(intent, CAMERA_INTENT);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case CAMERA_INTENT:
            //    if(requestCode == Activity.RESULT_OK){
                    bmpImage = (Bitmap) data.getExtras().get("data");
                    if(bmpImage != null){
                        imageView.setImageBitmap(bmpImage);
                    }else{
                        Toast.makeText(
                                this,
                                "Bitmap is Null",
                                Toast.LENGTH_SHORT
                        ).show();
                    }
//                } else {
//                    Toast.makeText(
//                            this,
//                            "Result isn't Ok",
//                            Toast.LENGTH_SHORT
//                    ).show();
//                }

                break;
        }
    }

    public void saveWord(View view){
        if(wordText.getText().toString().isEmpty()){
            Toast.makeText(
                    this,
                    "user Data is missing",
                    Toast.LENGTH_SHORT
            ).show();
        } else {
            Word word = new Word();
            word.setWord(wordText.getText().toString());
            word.setImage(DataConverter.converImage2ByteArray(bmpImage));
            wordDAO.insertWord(word);
            Toast.makeText(
                    this,
                    "insertion was successful",
                    Toast.LENGTH_SHORT
            ).show();

        }
    }

    public void showWord(View view){
        Intent intent = new Intent(this, ShowActivity.class);
        startActivity(intent);
    }
}