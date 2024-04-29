package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.net.URI;

public class LayoutExercise extends AppCompatActivity {

    Button btnOpen,btnNotify,btnLayout,btnCalculator,btnConnect3,btnPassing, btnMenu, btnOpeningMaps;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_exercise);
        btnOpen = findViewById(R.id.btnOpen);
        btnNotify = findViewById(R.id.btnButtonExercise);
        btnCalculator = findViewById(R.id.btnCalculator);
        btnConnect3 = findViewById(R.id.btnConnect);
        btnPassing = findViewById(R.id.btnPassing);
        btnMenu = findViewById(R.id.btnMenu);
        btnOpeningMaps = findViewById(R.id.btnOpeningMaps);
        btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LayoutExercise.this, MainActivity.class);
                startActivity(intent);
            }
        });
        btnNotify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LayoutExercise.this, ButtonExercise.class);
                startActivity(intent);
            }

        });
        btnCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LayoutExercise.this, CalculatorExercise.class);
                startActivity(intent);
            }
        });

        btnConnect3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LayoutExercise.this, Connect3.class);
                startActivity(intent);
            }
        });

        btnPassing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LayoutExercise.this, PassingIntentsExercise.class);
                startActivity(intent);
            }
        });
        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LayoutExercise.this, MenuExercise.class);
                startActivity(intent);
            }
        });

        btnOpeningMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LayoutExercise.this, MapsExercise.class);
                 startActivity(intent);

            }
        });
    }

}