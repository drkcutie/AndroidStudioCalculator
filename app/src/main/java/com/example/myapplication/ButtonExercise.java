package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Random;

public class ButtonExercise extends AppCompatActivity {

    Button btnClose;
    Button btnBackground;
    Button btnToast;
    Button btnChangeBtn;
    Button btnHide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_exercise);
        btnClose = findViewById(R.id.btnClose2);
        btnBackground = findViewById(R.id.btnBackground);
        btnToast = findViewById(R.id.btnToast);
        btnChangeBtn = findViewById(R.id.btnChangeBtn);
        btnHide = findViewById(R.id.btnHide);


        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnBackground.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random rnd = new Random();
                int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
                ConstraintLayout constraintLayout = findViewById(R.id.exerciseBackground);
                constraintLayout.setBackgroundColor(color);
            }
        });

        btnToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ButtonExercise.this, "This is my Toast message!",
                        Toast.LENGTH_LONG).show();
            }
        });

        btnChangeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Random rnd = new Random();
                int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));

                btnChangeBtn.setBackgroundColor(color);

            }
        });
        btnHide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(btnHide.getVisibility()== View.INVISIBLE)
                {
                    btnHide.setVisibility(View.VISIBLE);
                } btnHide.setVisibility(View.INVISIBLE);

            }
        });
    }
}