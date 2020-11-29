package com.example.try1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class studentSignIn extends AppCompatActivity {
    Button login_btn, moveToSignUp;
    EditText username, password;
    ProgressBar progSignP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_sign_in);
        getSupportActionBar().hide();

        moveToSignUp = findViewById(R.id.signup_screen);
        moveToSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveToSignPage();
            }
        });
    }

    public void loginUser(View view) {
        isUser();
        progSignP = findViewById(R.id.progSignP);
        progSignP.setVisibility(View.VISIBLE);
    }

    private void isUser() {
        username=findViewById(R.id.login_username);
        password=findViewById(R.id.login_password);
        final String userEnteredUsername = username.getEditableText().toString().trim();
        final String userEnteredPassword = password.getEditableText().toString().trim();


        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("patients");
        Query checkUser = reference.orderByChild("username").equalTo(userEnteredUsername);

        checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    username.setError(null);

                    String passwordFromDB = dataSnapshot.child(userEnteredUsername).child("password").getValue(String.class);

                    if (Objects.equals(passwordFromDB, userEnteredPassword)) {
                        username.setError(null);
                        //username.setErrorEnabled(false);

                      /*  login_btn = findViewById(R.id.btnLogin);

                        login_btn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                moveToDashPage();

                            }
                        });  */

                        Intent intent=new Intent(studentSignIn.this,patientSide.class);
                        startActivity(intent);
                        finish();
                    }
                    else {
                        password.setError("Wrong Password");
                        password.requestFocus();
                        progSignP.setVisibility(View.INVISIBLE);
                    }
                } else {
                    username.setError("No such User exist");
                    username.requestFocus();
                    progSignP.setVisibility(View.INVISIBLE);
                }
            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
    private void moveToSignPage(){
        Intent intent=new Intent(studentSignIn.this,studentSignup.class);
        startActivity(intent);
        finish();
//        Toast.makeText(getBaseContext(), "Sign in successfully" , Toast.LENGTH_SHORT ).show();

    }

    private void moveToDashPage(){
        Intent intent=new Intent(studentSignIn.this,patientSide.class);
        startActivity(intent);
        finish();
    }

}