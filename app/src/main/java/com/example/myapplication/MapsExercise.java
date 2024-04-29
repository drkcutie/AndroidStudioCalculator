package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MapsExercise extends AppCompatActivity {

    ConstraintLayout bg;

    ImageButton btnBali, btnMaui, btnParis, btnRome, btnTokyo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps_exercise);
        btnBali = findViewById(R.id.btnBali);
        btnMaui = findViewById(R.id.btnMaui);
        btnParis = findViewById(R.id.btnParis);
        btnRome = findViewById(R.id.btnRome);
        btnTokyo = findViewById(R.id.btnTokyo);
        bg = findViewById(R.id.bg);
        btnBali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent  = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:-8.27493503862646, 115.16743058751652"));
                startActivity(intent);


                bg.setBackgroundResource(R.drawable.bali);


            }
        });
        btnMaui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent  = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:20.724980448621768, -156.25314585669142"));
                startActivity(intent);
                bg.setBackgroundResource(R.drawable.maui);
            }
        });
        btnParis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent  = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:48.85848303988474, 2.2945510375926093"));
                startActivity(intent);
                bg.setBackgroundResource(R.drawable.paris);
            }
        });
        btnRome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent  = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:41.89033000223519, 12.492343552984483"));
                startActivity(intent);
                bg.setBackgroundResource(R.drawable.rome);
            }
        });
        btnTokyo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent  = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:35.72919480611475, 139.79916865153672"));
                startActivity(intent);
                bg.setBackgroundResource(R.drawable.tokyo);
            }
        });
    }



}