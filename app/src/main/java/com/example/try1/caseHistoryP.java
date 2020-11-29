package com.example.try1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class caseHistoryP extends AppCompatActivity {

    private CardView cPatient, cClinic, cTreat, cMedical;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case_history_p);
    }

    public void PatientP(View view) {
        Toast.makeText(caseHistoryP.this, "Clicked", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(caseHistoryP.this, patientDetailsP.class);
        startActivity(intent);

    }

    public void ClinicP(View view) {
        Toast.makeText(caseHistoryP.this, "Clicked", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(caseHistoryP.this, clinicalDataP.class);
        startActivity(intent);
    }

    public void TreatmentP(View view) {
        Toast.makeText(caseHistoryP.this, "Clicked", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(caseHistoryP.this, treatmentDataP.class);
        startActivity(intent);
    }

    public void MedicalP(View view) {
        Toast.makeText(caseHistoryP.this, "Clicked", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(caseHistoryP.this, medicalDetailsP.class);
        startActivity(intent);
    }
}
