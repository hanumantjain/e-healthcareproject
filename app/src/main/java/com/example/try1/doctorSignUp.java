package com.example.try1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class doctorSignUp extends AppCompatActivity {
    EditText regName1, regUsername1, regEmail1, regPhoneNo1, regPassword1;
    Button regBtn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_sign_up);
        getSupportActionBar().hide();

        regName1=findViewById(R.id.doc_Name);
        regUsername1=findViewById(R.id.doc_username);
        regEmail1=findViewById(R.id.doc_email);
        regPhoneNo1=findViewById(R.id.doc_phoneNo);
        regPassword1=findViewById(R.id.doc_password);
        regBtn1=findViewById(R.id.doc_button);


        regBtn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                FirebaseDatabase rootNode= FirebaseDatabase.getInstance();
                DatabaseReference ref=rootNode.getReference("doctor");

                //get all the values
                String name1=regName1.getEditableText().toString();
                String username1=regUsername1.getEditableText().toString();
                String email1=regEmail1.getEditableText().toString();
                String phoneNo1=regPhoneNo1.getEditableText().toString();
                String password1=regPassword1.getEditableText().toString();


                UserHelperClass1 helperClass1=new UserHelperClass1(name1,username1,password1,phoneNo1,email1);
                ref.child(username1).setValue(helperClass1);
                Toast.makeText(getBaseContext(), "Added SuccessFully" , Toast.LENGTH_SHORT ).show();
                Intent intent = new Intent(doctorSignUp.this, doctorSignIn.class);
                startActivity(intent);
                finish();


            }

        });

    }
}