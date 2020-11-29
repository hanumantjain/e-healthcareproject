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

public class treatmentDataP extends AppCompatActivity {

    DatabaseReference database;
    TextView eMedicineP, eMorningP , eAfternoonP ,eEveningP;
    TextView medicine1P, morning1P, afternoon1P, evening1P;
    TextView medicine2P, morning2P, afternoon2P, evening2P;
    TextView medicine3P, morning3P, afternoon3P, evening3P;
    TextView medicine4P, morning4P, afternoon4P, evening4P;
    TextView medicine5P, morning5P, afternoon5P, evening5P;
    TextView medicine6P, morning6P, afternoon6P, evening6P;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_treatment_data_p);

        eMedicineP = (TextView) findViewById(R.id.medicineP);
        eMorningP = (TextView) findViewById(R.id.morningP);
        eAfternoonP = (TextView) findViewById(R.id.afternoonP);
        eEveningP = (TextView) findViewById(R.id.eveningP);

        medicine1P = (TextView) findViewById(R.id.medicine1P);
        morning1P = (TextView) findViewById(R.id.morning1P);
        afternoon1P = (TextView) findViewById(R.id.afternoon1P);
        evening1P = (TextView) findViewById(R.id.evening1P);

        medicine2P = (TextView) findViewById(R.id.medicine2P);
        morning2P = (TextView) findViewById(R.id.morning2P);
        afternoon2P = (TextView) findViewById(R.id.afternoon2P);
        evening2P = (TextView) findViewById(R.id.evening2P);

        medicine3P = (TextView) findViewById(R.id.medicine3P);
        morning3P = (TextView) findViewById(R.id.morning3P);
        afternoon3P = (TextView) findViewById(R.id.afternoon3P);
        evening3P = (TextView) findViewById(R.id.evening3P);

        medicine4P = (TextView) findViewById(R.id.medicine4P);
        morning4P = (TextView) findViewById(R.id.morning4P);
        afternoon4P = (TextView) findViewById(R.id.afternoon4P);
        evening4P = (TextView) findViewById(R.id.evening4P);

        medicine5P = (TextView) findViewById(R.id.medicine5P);
        morning5P = (TextView) findViewById(R.id.morning5P);
        afternoon5P = (TextView) findViewById(R.id.afternoon5P);
        evening5P = (TextView) findViewById(R.id.evening5P);

        medicine6P = (TextView) findViewById(R.id.medicine6P);
        morning6P = (TextView) findViewById(R.id.morning6P);
        afternoon6P = (TextView) findViewById(R.id.afternoon6P);
        evening6P = (TextView) findViewById(R.id.evening6P);

        database = FirebaseDatabase.getInstance().getReference("ClinicalReports").child("Treatment");
        
    }

    @Override
    protected void onStart() {
        super.onStart();
        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                helperTreatment helperTreat = snapshot.getValue(helperTreatment.class);
                String m1 = helperTreat.medicine1;
                medicine1P.setText(m1);
                String m2 = helperTreat.medicine2;
                medicine2P.setText(m2);
                String m3 = helperTreat.medicine3;
                medicine3P.setText(m3);
                String m4 = helperTreat.medicine4;
                medicine4P.setText(m4);
                String m5 = helperTreat.medicine5;
                medicine5P.setText(m5);
                String m6 = helperTreat.medicine6;
                medicine6P.setText(m6);


                String m11 = helperTreat.morning1;
                morning1P.setText(m11);
                String m22 = helperTreat.morning2;
                morning2P.setText(m22);
                String m33 = helperTreat.morning3;
                morning3P.setText(m33);
                String m44 = helperTreat.morning4;
                morning4P.setText(m44);
                String m55 = helperTreat.morning5;
                morning5P.setText(m55);
                String m66 = helperTreat.morning6;
                morning6P.setText(m66);


                String a1 = helperTreat.afternoon1;
                afternoon1P.setText(a1);
                String a2 = helperTreat.afternoon2;
                afternoon2P.setText(a2);
                String a3 = helperTreat.afternoon3;
                afternoon3P.setText(a3);
                String a4 = helperTreat.afternoon4;
                afternoon4P.setText(a4);
                String a5 = helperTreat.afternoon5;
                afternoon5P.setText(a5);
                String a6 = helperTreat.afternoon6;
                afternoon6P.setText(a6);



                String e1 = helperTreat.evening1;
                evening1P.setText(e1);
                String e2 = helperTreat.evening2;
                evening2P.setText(e2);
                String e3 = helperTreat.evening3;
                evening3P.setText(e3);
                String e4 = helperTreat.evening4;
                evening4P.setText(e4);
                String e5 = helperTreat.evening5;
                evening5P.setText(e5);
                String e6 = helperTreat.evening6;
                evening6P.setText(e6);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

}