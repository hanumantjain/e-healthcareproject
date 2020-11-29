package com.example.try1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class clinicalDataP extends AppCompatActivity {

    private static final int SHOW_IMAGE_REQUEST = 1;
    private Button bBlood1, bUrine1, bECG1, bEndo1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clinical_data_p);

        viewClinic();
        buttonClinic();

    }

    private void buttonClinic() {
        bBlood1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(clinicalDataP.this,aa.class);
                startActivity(intent);

            }
        });
        bUrine1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(clinicalDataP.this,aa.class);
                startActivity(intent);
            }
        });
        bECG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(clinicalDataP.this,aa.class);
                startActivity(intent);
            }
        });
       bEndo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(clinicalDataP.this,aa.class);
                startActivity(intent);
            }
        });
    }

    public void viewClinic() {
        bBlood1 = (Button) findViewById(R.id.ButBloodP);
        bUrine1 = (Button) findViewById(R.id.butUrineP);
        bECG1 = (Button) findViewById(R.id.butECGP);
        bEndo1 = (Button) findViewById(R.id.butEndoP);

    }

}