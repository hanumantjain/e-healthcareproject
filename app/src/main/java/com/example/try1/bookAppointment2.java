package com.example.try1;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class bookAppointment2 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    boolean check = false;
    private CardView card9, card93, card10, card103, card11, card113, card1, card13, card2;
    TextView menu;
    TextView confirmdetails;
    String[] Doctor = {"Select Doctor", "Doctor1", "Doctor2", "Doctor3"};
    String[] specialist = {"Select Specialist","Allergist","Anesthesiologist","Cardiologist","Dermatologist","Endocrinologist","Gastroenterologist","Hematologist","Immunologist","Internist","Neurologist","Pulmonologist","Oncologist","Pediatrician","Psychiatrist","Radiologist","Rheumatologist","Urologist"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_appointment2);
        getSupportActionBar().hide();

        menu= findViewById(R.id.menu);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(bookAppointment2.this,patientSide.class);
                startActivity(intent);
                finish();
            }
        });
        confirmdetails = findViewById(R.id.confirmAppointment);
        confirmdetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(bookAppointment2.this,showBookedAppoitment.class);
                startActivity(intent);
                finish();
            }
        });
        card9 = findViewById(R.id.card9);
        card93 = findViewById(R.id.card93);
        card10 = findViewById(R.id.card10);
        card103 = findViewById(R.id.card103);
        card11 = findViewById(R.id.card11);
        card113 = findViewById(R.id.card113);
        card1 = findViewById(R.id.card1);
        card13 = findViewById(R.id.card13);
        card2 = findViewById(R.id.card2);
        Spinner spinner = findViewById(R.id.spinnerApp);
        Spinner spinner1 = findViewById(R.id.spinnerApp1);


        ArrayAdapter ad = new ArrayAdapter(this, android.R.layout.simple_spinner_item, Doctor);
        ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(ad);

        ArrayAdapter ad1 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, specialist);
        ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(ad1);

    }

    public void AM9(View view) {
        check = true;
        card9.setCardBackgroundColor(Color.rgb(200, 249, 251));

    }

    public void AM93(View view) {
        check = true;
        card93.setCardBackgroundColor(Color.rgb(200, 249, 251));

    }

    public void AM10(View view) {
        check = true;
        card10.setCardBackgroundColor(Color.rgb(200, 249, 251));

    }

    public void AM103(View view) {
        check = true;
        card103.setCardBackgroundColor(Color.rgb(200, 249, 251));

    }

    public void AM11(View view) {
        check = true;
        card11.setCardBackgroundColor(Color.rgb(200, 249, 251));

    }

    public void AM113(View view) {
        check = true;
        card113.setCardBackgroundColor(Color.rgb(200, 249, 251));

    }

    public void PM1(View view) {
        check = true;
        card1.setCardBackgroundColor(Color.rgb(200, 249, 251));

    }

    public void PM13(View view) {
        check = true;
        card13.setCardBackgroundColor(Color.rgb(200, 249, 251));

    }

    public void PM2(View view) {
        check = true;
        card2.setCardBackgroundColor(Color.rgb(200, 249, 251));

    }


    public void bookAppointment(View view) {
        if (check) {
            Toast.makeText(bookAppointment2.this, "Appointment Booked", Toast.LENGTH_SHORT).show();
            check = false;
        } else {
            Toast.makeText(bookAppointment2.this, "Please select time", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}