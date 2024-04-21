package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PassingIntentsExercise2 extends AppCompatActivity {
    TextView tfFirstName, tfLastName, tfGender,tfStudentID,  tfBirthDate, tfPhoneNumber,
    tfEmailAddress,tfReligion, tfEthnicity, tfCourse, tfAddress;

    Button btnReturn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passing_intents_exercise2);
        initialize();

        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }



    public void initialize()
    {
        tfFirstName = findViewById(R.id.tfFirstName);
        tfLastName = findViewById(R.id.tfLastName);
        tfGender = findViewById(R.id.tfGender);
        tfStudentID= findViewById(R.id.tfStudentID);
        tfBirthDate= findViewById(R.id.tfBirthDate);
        tfPhoneNumber= findViewById(R.id.tfPhoneNumber);
        tfEmailAddress= findViewById(R.id.tfEmailAddress);
        tfReligion = findViewById(R.id.tfReligion);
        tfEthnicity = findViewById(R.id.tfEthnicity);
        tfCourse = findViewById(R.id.tfCourse);
        tfAddress = findViewById(R.id.tfAddress);
        btnReturn = findViewById(R.id.btnReturn);
        String firstname , lastname, gender, studentId, birthdate, phonenumber,
                email, religion , ethnicity,course,  address;


        Intent intent = getIntent();
        firstname = intent.getStringExtra("firstname");
        lastname = intent.getStringExtra("lastname");
        gender = intent.getStringExtra("gender");
        studentId= intent.getStringExtra("studentid");
        birthdate= intent.getStringExtra("birthdate");
        phonenumber= intent.getStringExtra("phonenumber");
        email= intent.getStringExtra("email");
        religion= intent.getStringExtra("religion");
        ethnicity = intent.getStringExtra("ethnicity");
        course = intent.getStringExtra("course");
        address = intent.getStringExtra("address");

        tfFirstName.setText(firstname);
        tfLastName.setText(lastname);
        tfGender.setText(gender);
        tfStudentID.setText(studentId);
        tfBirthDate.setText(birthdate);
        tfPhoneNumber.setText(phonenumber);
        tfEmailAddress.setText(email);
        tfReligion.setText(religion);
        tfCourse.setText(course);
        tfEthnicity.setText(ethnicity);
        tfAddress.setText(address);
    }

}