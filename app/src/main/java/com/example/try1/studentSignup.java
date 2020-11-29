package com.example.try1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class studentSignup extends AppCompatActivity {
    private EditText regName, regUsername, regEmail, regPhoneNo, regPassword, patientDob, patientSex;
    private ProgressBar signUpP;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_signup);
        getSupportActionBar().hide();

        signUpP = findViewById(R.id.SignUpP);
        regName = findViewById(R.id.reg_PatientName);
        regUsername = findViewById(R.id.reg_username);
        regEmail = findViewById(R.id.reg_email);
        regPhoneNo = findViewById(R.id.reg_phoneNo);
        regPassword = findViewById(R.id.reg_password);
        patientDob = findViewById(R.id.patientDob);
        patientSex = findViewById(R.id.patientSex);

        Button regBtn = findViewById(R.id.reg_button);

        regBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                FirebaseDatabase rootNode= FirebaseDatabase.getInstance();
                DatabaseReference ref=rootNode.getReference("patients");

                //get all the values
                String name=regName.getEditableText().toString();
                String username=regUsername.getEditableText().toString();
                String email=regEmail.getEditableText().toString();
                String phoneNo=regPhoneNo.getEditableText().toString();
                String password=regPassword.getEditableText().toString();
                String dob = patientDob.getEditableText().toString();
                String sex = patientSex.getEditableText().toString();


                UserHelperClass helperClass=new UserHelperClass(name,username,password,phoneNo,email,dob,sex);
                ref.child(username).setValue(helperClass);
                Toast.makeText(getBaseContext(), "Added SuccessFully" , Toast.LENGTH_SHORT ).show();
                Intent intent = new Intent(studentSignup.this,studentSignIn.class);
                startActivity(intent);
                finish();


            }

        });
    }
}