package com.example.try1;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class patientDetailsP extends AppCompatActivity {

    private TextView NameP,IdP, SexP, DobP,PhoneP1,EmailP;
    private DatabaseReference database;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_details_p);

        NameP = (TextView) findViewById(R.id.editNameP);
        IdP = (TextView) findViewById(R.id.editHealthIdP);
        SexP = (TextView) findViewById(R.id.editSexP);
        DobP = (TextView) findViewById(R.id.editDoBP);
        PhoneP1 = (TextView) findViewById(R.id.editPhoneP1);
        EmailP = (TextView) findViewById(R.id.editEmail1);


        database = FirebaseDatabase.getInstance().getReference("patients").child("manu");

    }

    @Override
    protected void onStart() {
        super.onStart();
        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                UserHelperClass helperClass= snapshot.getValue(UserHelperClass.class);
                String id = helperClass.username;
                IdP.setText(id);
                String dob = helperClass.dob;
                DobP.setText(dob);
                String sex = helperClass.sex;
                SexP.setText(sex);
                String NNN = helperClass.patientname;
                NameP.setText(NNN);
                String Phone = helperClass.phoneno;
                PhoneP1.setText(Phone);
                String mail = helperClass.email;
                EmailP.setText(mail);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}