package com.example.retoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initConfig();
    }

    private void initConfig(){
        randomHex();

     }


    @SuppressLint("Range")
    public void buttonActionPerformed(View view){
        TextView textViewHex1;
        EditText editTextColorHex;
        textViewHex1 = (TextView) findViewById(R.id.textViewHex1);
        editTextColorHex = (EditText) findViewById(R.id.editTextColorHex);


        randomHex();

        String firstHex = "";
        try {
            firstHex = editTextColorHex.getText().toString();
            textViewHex1.setBackgroundColor(Color.parseColor(firstHex));
            textViewHex1.setText(firstHex);
        }catch (Exception e){
            if(firstHex.equals(" ")) {
                String[] HexRand = randomHex();
                textViewHex1.setBackgroundColor(Color.parseColor(HexRand[4]));
                textViewHex1.setText(HexRand[4]);
            }
            else{editTextColorHex.setError("Invalid Color");
            }
        }
    }

    @SuppressLint("Range")
    protected String[] randomHex() {


        String[] randomHex1;
        int Nmax = 5;
        String colorCode;

        randomHex1 = new String[Nmax];

        EditText editTextColorHex;
        TextView textViewHex1, textViewHex2 ,textViewHex3,textViewHex4,textViewHex5;



        editTextColorHex = (EditText) findViewById(R.id.editTextColorHex);
        textViewHex1 = (TextView) findViewById(R.id.textViewHex1);
        textViewHex2 = (TextView) findViewById(R.id.textViewHex2);
        textViewHex3 = (TextView) findViewById(R.id.textViewHex3);
        textViewHex4 = (TextView) findViewById(R.id.textViewHex4);
        textViewHex5 = (TextView) findViewById(R.id.textViewHex5);




        for(int y =0; y < randomHex1.length; y++){
            Random obj = new Random();
            int rand_num = obj.nextInt(0xffffff + 1);
            colorCode = String.format("#%06x", rand_num);
            randomHex1[y] = colorCode;
        }
            textViewHex2.setBackgroundColor(Color.parseColor(randomHex1[0]));
            textViewHex2.setText(randomHex1[0]);
            textViewHex3.setBackgroundColor(Color.parseColor(randomHex1[1]));
            textViewHex3.setText(randomHex1[1]);
            textViewHex4.setBackgroundColor(Color.parseColor(randomHex1[2]));
            textViewHex4.setText(randomHex1[2]);
            textViewHex5.setBackgroundColor(Color.parseColor(randomHex1[3]));
            textViewHex5.setText(randomHex1[3]);
        return randomHex1;
    }
}