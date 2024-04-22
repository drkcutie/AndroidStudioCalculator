package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.Random;

public class MenuExercise extends AppCompatActivity {
    Button btnChanger;
    int imageIndex = 0;
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
            btnChanger.setBackgroundResource(R.drawable.round_button);

            Toast.makeText(this, "Reset Object Item is clicked", Toast.LENGTH_SHORT).show();
        }else if (item.getItemId() == R.id.btnChangeBG)
        {
            int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
            btnChanger.setBackgroundColor(color);

        }else if (item.getItemId() == R.id.btnChangeTextColor)
        {
            int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
            btnChanger.setTextColor(color);
        }else if (item.getItemId() == R.id.btnChangeShape)
        {
            int[] images = {R.drawable.kcajero,R.drawable.zakfloreta, R.drawable.lainesegundo, R.drawable.derrickbinangbang,R.drawable.tristantolentino};
            btnChanger.setBackgroundResource(images[imageIndex]);
            imageIndex++;
            if(imageIndex == images.length)
                imageIndex = 0;

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

        }
        else if (item.getItemId() == R.id.mItemExit) {
            finish();
        }

        return true;
    }
}