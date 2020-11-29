package com.example.try1;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class checkSchedule2 extends AppCompatActivity {

    Button button_fill_case_history,button_upload_prescription,button_provide_transaction,button_upload_lab_reports;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_schedule2);

        button_fill_case_history=findViewById(R.id.button_fill_case_history);
        button_upload_prescription=findViewById(R.id.button_upload_prescription);
        button_upload_lab_reports=findViewById(R.id.button_upload_lab_reports);
        button_provide_transaction =findViewById(R.id.button_provide_transaction);

        button_fill_case_history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(checkSchedule2.this,fillCaseHistory.class);
                startActivity(intent);
            }
        });

        button_upload_prescription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(checkSchedule2.this,uploadPrescription.class);
                startActivity(intent);
            }
        });

        button_upload_lab_reports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(checkSchedule2.this,uploadLabReports.class);
                startActivity(intent);
            }
        });

        button_provide_transaction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(checkSchedule2.this,fill_transaction.class);
                startActivity(intent);
            }
        });
    }
}


//        String patientName = "Patient Name is not Set";
//        Bundle extras = getIntent().getExtras();
//        if (extras != null) {
//            patientName = extras.getString("patientName");
//        }
//
//        nameTxt.setText(patientName);







