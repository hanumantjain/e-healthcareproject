package com.example.try1;


import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class patientDetailsD extends fillCaseHistory {

    private TextView  eId, eSex, eDob, Name1, PhoneP, EmailD;
    private Query database;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_details_d);


        Name1 = (TextView) findViewById(R.id.editName1);
        eId = (TextView) findViewById(R.id.editHealthId);
        eSex = (TextView) findViewById(R.id.editSex);
        eDob = (TextView) findViewById(R.id.editDoB);
        PhoneP= (TextView) findViewById(R.id.editPhone);
        EmailD = (TextView) findViewById(R.id.editEmailD);

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
                eId.setText(id);
                String dob = helperClass.dob;
                eDob.setText(dob);
                String sex = helperClass.sex;
                eSex.setText(sex);
                String NNN = helperClass.patientname;
                Name1.setText(NNN);
                String Phone = helperClass.phoneno;
                PhoneP.setText(Phone);
                String Email = helperClass.email;
                EmailD.setText(Email);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}