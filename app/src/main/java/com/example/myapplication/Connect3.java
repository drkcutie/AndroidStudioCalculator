package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class Connect3 extends AppCompatActivity {


    Button[][] buttons;
    int[][] gameStatus;
    TextView playerText;
    ConstraintLayout layout;

    //Player 1 turn == 1 && Player 2 turn == 2
    int turn;

    static int ctr = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect3);
        initialize();

    }

    public void switchTurns() {

        turn = turn == 1 ? 2 : 1;
        String message = turn == 1 ? "Player 1's Turn" : "Player 2's Turn";
        int color = ((turn == 1) ? Color.parseColor("#B97C7C") : Color.parseColor("#5492C8"));
        ColorDrawable colorDrawable = new ColorDrawable(color);
        layout.setBackground(colorDrawable);
        playerText.setText(message);

    }

    public void btnBackground(int row, int column) {

        int color = (turn == 1) ? Color.RED : Color.BLUE;
        buttons[row][column].setBackgroundColor(color);

    }
    public void reset()
    {
        turn = 1;
        gameStatus = new int[5][5];
        ctr  = 0;
        for(int i = 0 ; i < 5; i++)
        {
            for(int j = 0 ; j < 5;j++)
            {
                buttons[i][j].setBackgroundColor(Color.parseColor("#D5D5D5"));
            }
        }
        playerText.setText("Player 1's Turn");
        layout.setBackgroundColor(Color.parseColor("#B97C7C"));
        setClickable(true);

    }

    public void setClickable(boolean click) {

        if (click) {
            for (int i = 0; i < 5; i++) {
                if (gameStatus[0][i] == 0) {
                    buttons[0][i].setClickable(true);
                }
            }
        } else {
            for (int i = 0; i < 5; i++) {
                buttons[0][i].setClickable(false);
            }
        }


    }



    public void checkDraw()
    {
        ctr++;
        if(ctr == 25)
        {
            Toast.makeText(this, "Game draw.", Toast.LENGTH_SHORT).show();
            playerText.setText("Game draw.");
            setClickable(false);
        }

    }
    public int getVal(int row,int col)
    {
        if(row >= 5 || col >= 5 || row < 0 || col < 0)
            return 0;
        else {
            return gameStatus[row][col];
        }
    }
    public void checkElement(int row , int col)
    {
        boolean horizontal = false, vertical = false, diagonalLeft = false , diagonalRight = false;
        int self = getVal(row, col);

        vertical= getVal(row - 1, col) == self && self == getVal(row  + 1, col);
        horizontal = getVal(row, col - 1) == self && self == getVal(row , col + 1);
        diagonalLeft = getVal(row  - 1 , col - 1) == self && self == getVal(row + 1, col + 1);
        diagonalRight = getVal(row - 1, col + 1) == self && self ==  getVal(row + 1, col - 1);

        if(vertical || horizontal || diagonalLeft || diagonalRight)
        {
            String winner = self == 1 ? "Player 1" : "Player 2";
            Toast.makeText(this, winner + " wins", Toast.LENGTH_SHORT).show();
            String congrats = winner + ". You win!";
            playerText.setText(congrats);
            // need to fix font size when notifying the winner


            setClickable(false);
        }
    }

    public void checkAllElement()
    {
        for(int i = 0 ; i < 5; i++)
        {
            for(int j = 0 ; j < 5; j++)
            {
                if(gameStatus[i][j] != 0)
                {
                    checkElement(i, j);
                }
            }
        }
    }




    synchronized public void putElement(int row, int column) {


        if (row + 1 < 5 && gameStatus[row + 1][column] == 0) {
            btnBackground(row, column);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    buttons[row][column].setBackgroundColor(Color.parseColor("#D5D5D5"));
                    putElement(row + 1, column);
                }
            }, 50);
        } else {
            btnBackground(row, column);
            gameStatus[row][column] = turn;
            switchTurns();
            if (row == 0) {
                buttons[row][column].setClickable(false);
            }
            setClickable(true);


            //Check gameStatus
            checkDraw();
            checkAllElement();


        }

    }


    public void initialize() {
        //Initialize layout and text;
        Toast.makeText(this, "Binangbang, Derrick C. BATCH 1 - CONNECT 3", Toast.LENGTH_SHORT).show();
        playerText = findViewById(R.id.playerTurn);
        layout = findViewById(R.id.Layout);


        buttons = new Button[5][5];
        int[] btn = {R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4, R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9, R.id.btn10,
                R.id.btn11, R.id.btn12, R.id.btn13, R.id.btn14, R.id.btn15, R.id.btn16, R.id.btn17, R.id.btn18, R.id.btn19, R.id.btn20,
                R.id.btn21, R.id.btn22, R.id.btn23, R.id.btn24, R.id.btn25};

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                Button b = (Button) findViewById(btn[i * 5 + j]);
                buttons[i][j] = b;
            }
        }

        for (int i = 0; i < 5; i++) {
            int finalI = i;
            buttons[0][i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    setClickable(false);
                    putElement(0, finalI);
                    //Test the game result

                    Log.d("Connect3", Arrays.deepToString(gameStatus));
                }
            });
        }

        Button reset = (Button) findViewById(R.id.btnReset);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reset();
            }
        });

        //initialize game to 0;
        gameStatus = new int[5][5];
        turn = 1;

    }

}