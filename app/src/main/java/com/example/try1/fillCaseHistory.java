package com.example.try1;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class fillCaseHistory extends AppCompatActivity {

    private CardView cPatient, cClinic, cTreat, cMedical;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill_case_history);
    }

    public void Patient(View view) {
        Intent intent = new Intent(this, patientDetailsD.class);
        startActivity(intent);

    }

    public void Clinic(View view) {
        Intent intent = new Intent(this, clinicalDataD.class);
        startActivity(intent);
    }

    public void Treatment(View view) {
        Intent intent = new Intent(this, treatmentDataD.class);
        startActivity(intent);
    }

    public void Medical(View view) {
        Intent intent = new Intent(this, medicalDetailsD.class);
        startActivity(intent);
    }
}
