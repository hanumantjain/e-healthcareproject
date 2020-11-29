package com.example.try1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class medicalOrder extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medical_order);
        getSupportActionBar().hide();
    }
}