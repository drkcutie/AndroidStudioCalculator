package com.example.myapplication;

import static android.app.ProgressDialog.show;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class CalculatorExercise extends AppCompatActivity {

    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0,btnDivide,btnMultiply,btnPlus,btnEqual,btnDecimal,btnMinus;
    TextView inputBox, inputResult;

    String elements = "";
    Calculator calculator = new Calculator();

//    boolean hasDecimal = false;
//    String temp, prev;
//    char op = ' ';

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator_exercise);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btn0 = findViewById(R.id.btn0);
        btnDivide = findViewById(R.id.btnDivide);
        btnMultiply = findViewById(R.id.btnMultiply);
        btnPlus = findViewById(R.id.btnPlus);
        btnEqual = findViewById(R.id.btnEqual);
        btnDecimal = findViewById(R.id.btnDecimal);
        btnMinus = findViewById(R.id.btnMinus);
        inputBox = findViewById(R.id.inputBox);
        inputResult = findViewById(R.id.Result);




        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                elements+="1";
                inputBox.append("1");
            }
        });btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                elements+='2';
                inputBox.append("2");
            }
        });btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                elements+='3';
                inputBox.append("3");
            }
        });


        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                elements+='4';
                inputBox.append("4");
            }
        });btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                elements+='5';
                inputBox.append("5");
            }
        });btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                elements+='6';
                inputBox.append("6");
            }
        });btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                elements+='7';
                inputBox.append("7");
            }
        });btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                elements+='8';
                inputBox.append("8");
            }
        });btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                elements+='9';
                inputBox.append("9");
            }
        });btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                elements+='0';
                inputBox.append("0");
            }
        });

        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String currentText = inputBox.getText().toString(); // Get current text
                char[] temp = currentText.toCharArray();
                int length = currentText.length();
                if(length > 0 && isOperator(temp[length - 1]) )
                {
                    String str  = currentText.substring( 0, currentText.length() - 1 );
                    inputBox.setText(str + "*");
                    calculator.replaceOperator('*');
                }
                else if (length > 0)
                {
                    calculator.addOperand(elements);
                    elements= "";
                    inputBox.append("*");
                    String res = calculator.addOperator('*').toString();
                    double decimal = Double.parseDouble(res);
                    if(decimal == Math.floor(decimal))
                    {
                        inputResult.setText(String.valueOf(String.format("%.0f", decimal)));
                    }
                    else
                    {
                        inputResult.setText(String.format(String.valueOf(decimal)));
                    }
                }
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String currentText = inputBox.getText().toString(); // Get current text
                char[] temp = currentText.toCharArray();
                int length = currentText.length();
                if(length > 0 && isOperator(temp[length - 1]) )
                {
                    String str  = currentText.substring( 0, currentText.length() - 1 );
                    inputBox.setText(str + "-");
                    calculator.replaceOperator('-');
                }
                else if (length > 0)
                {
                    calculator.addOperand(elements);
                    elements= "";
                    inputBox.append("-");
                    String res = calculator.addOperator('-').toString();
                    double decimal = Double.parseDouble(res);
                    if(decimal == Math.floor(decimal))
                    {
                        inputResult.setText(String.valueOf(String.format("%.0f", decimal)));
                    }
                    else
                    {
                        inputResult.setText(String.format(String.valueOf(decimal)));
                    }

                }
            }
        });btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String currentText = inputBox.getText().toString(); // Get current text
                char[] temp = currentText.toCharArray();
                int length = currentText.length();
                if(length > 0 && isOperator(temp[length - 1]) )
                {
                    String str  = currentText.substring( 0, currentText.length() - 1 );
                    inputBox.setText(str + "+");
                    calculator.replaceOperator('+');
                }
                else if(length > 0)
                {

                    calculator.addOperand(elements);
                    elements= "";
                    inputBox.append("+");
                    String res = calculator.addOperator('+').toString();
                    double decimal = Double.parseDouble(res);
                    if(decimal == Math.floor(decimal))
                    {
                        inputResult.setText(String.valueOf(String.format("%.0f", decimal)));
                    }
                    else
                    {
                        inputResult.setText(String.format(String.valueOf(decimal)));
                    }
                }
            }
        });btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String currentText = inputBox.getText().toString(); // Get current text
                char[] temp = currentText.toCharArray();
                int length = currentText.length();
                if(length > 0 && isOperator(temp[length - 1]) )
                {
                    String str  = currentText.substring( 0, currentText.length() - 1 );
                    inputBox.setText(str + "/");
                    calculator.replaceOperator('/');
                }
                else if(length > 0)
                {

                    calculator.addOperand(elements);
                    elements= "";
                    inputBox.append("/");
                    String res = "";
                    try{

                         res = calculator.addOperator('/').toString();
                    }catch (Exception e)
                    {
                        inputResult.setText("Division by 0");
                        reset();
                        return;
                    }

                    double decimal = Double.parseDouble(res);
                    if(decimal == Math.floor(decimal))
                    {
                        inputResult.setText(String.valueOf(String.format("%.0f", decimal)));
                    }

                    else
                    {
                        inputResult.setText(String.format(String.valueOf(decimal)));
                    }
                }
            }
        });
        btnEqual.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("DefaultLocale")
            @Override
            public void onClick(View view) {
//                Toast.makeText(CalculatorExercise.this, String.valueOf(calculator.storeInfixValue()),
//                        Toast.LENGTH_LONG).show();
                if(!elements.isEmpty())
                {

                    calculator.addOperand(elements);
                    elements = "";
                }
                double decimal = 0.0;
                try{

                    decimal = Double.parseDouble(calculator.storeInfixValue());
                }catch (Exception e)
                {
                    inputResult.setText("Division by 0");
                    reset();
                    return;
                }
                if(decimal == Math.floor(decimal))
                {
                    inputResult.setText(String.valueOf(String.format("%.0f", decimal)));
                }
                else
                {
                    inputResult.setText(String.format(String.valueOf(decimal)));
                }


                reset();

            }
        });

        btnDecimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String currentText = inputBox.getText().toString(); // Get current text
                int i = currentText.length() - 2;
                while(i >= 0 && !isOperator(currentText.charAt(i)) )
                {
                    if(currentText.charAt(i) == '.')
                    {
                        return;
                    }
                    i--;
                }
                char[] temp = currentText.toCharArray();
                int length = currentText.length();
                if(length > 0 && temp[length - 1 ] == '.')
                {
                    String str  = currentText.substring( 0, currentText.length() - 1 );
                    inputBox.setText(str);
                    elements = elements.substring(0, elements.length() -1 );
                }
                else
                {
                    elements+=".";
                    inputBox.append(".");
                }
            }
        });


    }

    public boolean isOperator(char c)
    {
        if(c == '+')
            return true;
        else if (c == '-')
            return true;
        else if(c == '/')
            return true;
        else return c == '*';
    }
    public void reset()
    {
        inputBox.setText("");
        elements = "";
        calculator.elements.clear();
        calculator.queue.clear();
        calculator.operator.clear();
    }




}