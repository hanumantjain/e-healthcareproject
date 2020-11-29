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

public class medicalDetailsP extends AppCompatActivity {

    private TextView MedicalDescription,healthIDP;
    private DatabaseReference database;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medical_details_p);

        MedicalDescription = (TextView) findViewById(R.id.MedicalDescription);
        healthIDP = (TextView) findViewById(R.id.HealthIdP);

        database = FirebaseDatabase.getInstance().getReference("ClinicalReports").child("Medical");


    }

    @Override
    protected void onStart() {
        super.onStart();
        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                helperClass help = snapshot.getValue(helperClass.class);
                String description = help.medical;
                MedicalDescription.setText(description);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}