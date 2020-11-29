package com.example.try1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class medicalDetailsD extends fillCaseHistory {

    private EditText editMedicalDescription;
    private TextView editHealthID;
    private Button button1;
    private DatabaseReference database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medical_details_d);

        editMedicalDescription = (EditText) findViewById(R.id.editMedicalDescription);

        editHealthID = (TextView) findViewById(R.id.editHealthId);

        button1 = (Button) findViewById(R.id.saveMedical);

        database = FirebaseDatabase.getInstance().getReference("ClinicalReports");

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String description = editMedicalDescription.getEditableText().toString();

                helperClass medical = new helperClass(description);

                database.child("Medical").setValue(medical);
                Toast.makeText(medicalDetailsD.this, "Saved", Toast.LENGTH_SHORT).show();

            }
        });

    }


}
