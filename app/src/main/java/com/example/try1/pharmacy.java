package com.example.try1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class pharmacy extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pharmacy);
        getSupportActionBar().hide();
    }
}