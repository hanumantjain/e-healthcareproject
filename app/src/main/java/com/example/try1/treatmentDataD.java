package com.example.try1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class treatmentDataD extends fillCaseHistory {

    TextView eMedicine, eMorning , eAfternoon ,eEvening;
    EditText medicine1, morning1, afternoon1, evening1;
    EditText medicine2, morning2, afternoon2, evening2;
    EditText medicine3, morning3, afternoon3, evening3;
    EditText medicine4, morning4, afternoon4, evening4;
    EditText medicine5, morning5, afternoon5, evening5;
    EditText medicine6, morning6, afternoon6, evening6;
    Button saveMedicine;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_treatment_data_d);

        eMedicine = (TextView) findViewById(R.id.medicine);
        eMorning = (TextView) findViewById(R.id.morning);
        eAfternoon = (TextView) findViewById(R.id.afternoon);
        eEvening = (TextView) findViewById(R.id.evening);

        medicine1 = (EditText) findViewById(R.id.medicine1);
        morning1 = (EditText) findViewById(R.id.morning1);
        afternoon1 = (EditText) findViewById(R.id.afternoon1);
        evening1 = (EditText) findViewById(R.id.evening1);

        medicine2 = (EditText) findViewById(R.id.medicine2);
        morning2 = (EditText) findViewById(R.id.morning2);
        afternoon2 = (EditText) findViewById(R.id.afternoon2);
        evening2 = (EditText) findViewById(R.id.evening2);

        medicine3 = (EditText) findViewById(R.id.medicine3);
        morning3 = (EditText) findViewById(R.id.morning3);
        afternoon3 = (EditText) findViewById(R.id.afternoon3);
        evening3 = (EditText) findViewById(R.id.evening3);

        medicine4 = (EditText) findViewById(R.id.medicine4);
        morning4 = (EditText) findViewById(R.id.morning4);
        afternoon4 = (EditText) findViewById(R.id.afternoon4);
        evening4 = (EditText) findViewById(R.id.evening4);

        medicine5 = (EditText) findViewById(R.id.medicine5);
        morning5 = (EditText) findViewById(R.id.morning5);
        afternoon5 = (EditText) findViewById(R.id.afternoon5);
        evening5 = (EditText) findViewById(R.id.evening5);

        medicine6 = (EditText) findViewById(R.id.medicine6);
        morning6 = (EditText) findViewById(R.id.morning6);
        afternoon6 = (EditText) findViewById(R.id.afternoon6);
        evening6 = (EditText) findViewById(R.id.evening6);

        saveMedicine = (Button) findViewById(R.id.saveMedicine);

        saveMedicine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseDatabase db = FirebaseDatabase.getInstance();
                DatabaseReference myRef = db.getReference("ClinicalReports");


                String med1 = medicine1.getEditableText().toString();
                String med2 = medicine2.getEditableText().toString();
                String med3 = medicine3.getEditableText().toString();
                String med4 = medicine4.getEditableText().toString();
                String med5 = medicine5.getEditableText().toString();
                String med6 = medicine6.getEditableText().toString();

                String morn1 = morning1.getEditableText().toString();
                String morn2 = morning2.getEditableText().toString();
                String morn3 = morning3.getEditableText().toString();
                String morn4 = morning4.getEditableText().toString();
                String morn5 = morning5.getEditableText().toString();
                String morn6 = morning6.getEditableText().toString();

                String aft1 = afternoon1.getEditableText().toString();
                String aft2 = afternoon2.getEditableText().toString();
                String aft3 = afternoon3.getEditableText().toString();
                String aft4 = afternoon4.getEditableText().toString();
                String aft5 = afternoon5.getEditableText().toString();
                String aft6 = afternoon6.getEditableText().toString();

                String even1 = evening1.getEditableText().toString();
                String even2 = evening2.getEditableText().toString();
                String even3 = evening3.getEditableText().toString();
                String even4 = evening4.getEditableText().toString();
                String even5 = evening5.getEditableText().toString();
                String even6 = evening6.getEditableText().toString();


                helperTreatment helperTreat = new helperTreatment(med1,med2,med3,med4,med5,med6,morn1,morn2,morn3,morn4,morn5,morn6,aft1,aft2,aft3,aft4,aft5,aft6,even1,even2,even3,even4,even5,even6);
                myRef.child("Treatment").setValue(helperTreat);


                Toast.makeText(treatmentDataD.this, "Saved", Toast.LENGTH_SHORT).show();
            }
        });


    }

}