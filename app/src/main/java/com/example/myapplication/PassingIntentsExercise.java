package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioGroup;

public class PassingIntentsExercise extends AppCompatActivity {

   EditText firstName;
   EditText lastName;
   EditText birthDate;
   EditText phoneNumber;
   EditText email;
   RadioGroup gender[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passing_intents_exercise);
    }

    public void initialize()
    {
        firstName = findViewById(R.id.fieldFirstName);
        lastName = findViewById(R.id.fieldLastName);
        birthDate = findViewById(R.id.fieldBirthDate);
        phoneNumber = findViewById(R.id.fieldNumber);

    }
}