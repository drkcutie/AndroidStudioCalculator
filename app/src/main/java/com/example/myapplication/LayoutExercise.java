package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LayoutExercise extends AppCompatActivity {

    Button btnOpen;
    Button btnNotify;
    Button btnLayout;
    Button btnCalculator;

    Button btnConnect3;

    Button btnPassing;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_exercise);
        btnOpen = findViewById(R.id.btnOpen);
        btnNotify = findViewById(R.id.btnButtonExercise);
        btnCalculator = findViewById(R.id.btnCalculator);
        btnConnect3 = findViewById(R.id.btnConnect);
        btnPassing = findViewById(R.id.btnPassing);
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
                Intent intent = new Intent (LayoutExercise.this, PassingIntentsExercise.class);
                startActivity(intent);
            }
        });

//        final boolean[] status = {false};
//        btn3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                final int min = 1;
//                final int max = 10;
//                final int random = new Random().nextInt((max - min) + 1) + min;
//                if(!status[0])
//                {
//                    setActivityBackgroundColor(1);
//                    status[0] = true;
//                }
//                else
//                {
//                    setActivityBackgroundColor(0);
//                    status[0] = false;
//                }
//
//
//
//
//            }
//        });


    }
//    public void setActivityBackgroundColor(int color) {
//        ConstraintLayout layout = findViewById(R.id.background);
//        if(color == 1)
//            layout.setBackgroundColor(BLACK);
//        else
//            layout.setBackgroundColor(WHITE);
//
//
//    }

}