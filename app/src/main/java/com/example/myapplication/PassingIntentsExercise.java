package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class PassingIntentsExercise extends AppCompatActivity {

    EditText firstName, lastName, birthDate, phoneNumber, email , studentID, address,religion
            , ethnicity, course;

    Button clear, submit, genderMale, genderFemale, genderOther;

    RadioGroup groupGender;
    EditText[] editText;
    String gender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passing_intents_exercise);
        initialize();


        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firstName.setText("");
                lastName.setText("");
                groupGender.clearCheck();
                studentID.setText("");
                birthDate.setText("");
                phoneNumber.setText("");
                email.setText("");
                religion.setText("");
                ethnicity.setText("");
                course.setText("");
                address.setText("");
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for(int i = 0 ; i < editText.length; i++)
                {
                    if(editText[i].getText().toString().length() == 0)
                    {
                        Toast.makeText(PassingIntentsExercise.this, "Please ensure all fields are filled out before proceeding", Toast.LENGTH_SHORT).show();
                        return;
                    }
                }
                int selected = groupGender.indexOfChild(findViewById(groupGender.getCheckedRadioButtonId())); // Assuming groupGender is your RadioGroup variable
                String gender;
                switch (selected) {
                    case 0:
                        gender = "Male";
                        break;
                    case 1:
                        gender = "Female";
                        break;
                    case 2:
                        gender = "Other";
                        break;
                    default:
                        Toast.makeText(PassingIntentsExercise.this, "Please ensure all fields are filled out before proceeding", Toast.LENGTH_SHORT).show();
                        return;
                }
                ;

                Intent intent = new Intent(PassingIntentsExercise.this, PassingIntentsExercise2.class);
                intent.putExtra("firstname", firstName.getText().toString());
                intent.putExtra("lastname", lastName.getText().toString());
               intent.putExtra("gender",gender);
                intent.putExtra("studentid", studentID.getText().toString());
                intent.putExtra("birthdate",birthDate.getText().toString());
                intent.putExtra("phonenumber",phoneNumber.getText().toString());
                intent.putExtra("email",email.getText().toString());
                intent.putExtra("religion",religion.getText().toString());
                intent.putExtra("ethnicity",ethnicity.getText().toString());
                intent.putExtra("course",course.getText().toString());
                intent.putExtra("address",address.getText().toString());
                startActivity(intent);
                System.out.println("Successfully submitted");
            }
        });


    }


public void initialize()
{

    firstName = findViewById(R.id.fieldFirstName);
    lastName = findViewById(R.id.fieldLastName);
    groupGender = findViewById(R.id.groupGender);
    genderMale = findViewById(R.id.RbtnMale);
    genderFemale = findViewById(R.id.RbtnFemale);
    genderOther = findViewById(R.id.RbtnOthers);
    studentID = findViewById(R.id.fieldStudentID);
    birthDate = findViewById(R.id.fieldBirthDate);
    phoneNumber = findViewById(R.id.fieldNumber);
    email = findViewById(R.id.fieldEmail);
    religion = findViewById(R.id.fieldReligion);
    ethnicity = findViewById(R.id.fieldEthnicity);
    course = findViewById(R.id.fieldCourse);
    address = findViewById(R.id.fieldAddress);
    clear = findViewById(R.id.btnClearForm);
    editText = new EditText[]{
            firstName, lastName, studentID, birthDate, phoneNumber, email, religion, ethnicity, course, address
};
    submit = findViewById(R.id.btnSubmitForm);
    System.out.println("StudentID: "+ firstName);
    System.out.println("Clear button: "+clear);
}


}
