package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.Random;

public class MenuExercise extends AppCompatActivity {
    Button btnChanger;
    int textIndex = 0;
    int sizeIndex = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_exercise);
        btnChanger = findViewById(R.id.btnTransformingButton);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.choice_menu, menu);

        return  true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        Drawable drawable = btnChanger.getBackground();
        Random rnd = new Random();


        if(item.getItemId() == R.id.mItemChange)
        {
            Toast.makeText(this, "Edit Object Item is clicked", Toast.LENGTH_SHORT).show();

        }else if (item.getItemId() == R.id.mItemReset)
        {
            btnChanger.setBackgroundColor(Color.parseColor("#FF2196F3"));
            btnChanger.setLayoutParams(new LinearLayout.LayoutParams(500,500));
            btnChanger.setText("Button");
            Toast.makeText(this, "Reset Object Item is clicked", Toast.LENGTH_SHORT).show();
        }else if (item.getItemId() == R.id.btnChangeClickable)
        {
            if(btnChanger.getVisibility() == View.VISIBLE)
            {
                btnChanger.setVisibility(View.INVISIBLE);
            }
            else
            {
                btnChanger.setVisibility(View.VISIBLE);
            }
        }else if (item.getItemId() == R.id.btnChangeTextColor)
        {
            int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
            btnChanger.setTextColor(color);
        }else if (item.getItemId() == R.id.btnChangeColor)
        {

            int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
            btnChanger.setBackgroundColor(color);

        }else if (item.getItemId() == R.id.btnChangeSize)
        {
            int [] height = {500, 600, 700};
            int [] width = {500, 600, 700};

            btnChanger.setLayoutParams(new LinearLayout.LayoutParams(width[sizeIndex], height[sizeIndex]));

            Toast.makeText(this, "Size Index: " + sizeIndex, Toast.LENGTH_SHORT).show();
            sizeIndex++;
            if(sizeIndex == height.length)
                sizeIndex = 0;
        }else if(item.getItemId() == R.id.btnChangeText)
        {
            String [] text = {"Hello", "Android", "Studio"};
            btnChanger.setText(text[textIndex]);
            textIndex++;
            if(textIndex == text.length)
            {
                textIndex = 0;
            }
        }
        else if (item.getItemId() == R.id.mItemExit) {
            finish();
        }

        return true;
    }
}