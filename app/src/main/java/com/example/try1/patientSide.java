package com.example.try1;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class patientSide extends AppCompatActivity implements View.OnClickListener {
    public CardView card1,card2,card3,card4,card5,card6;
    Button livechat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_side);
        getSupportActionBar().hide();

        livechat = findViewById(R.id.btn_live_chat);

        livechat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(patientSide.this,liveChat.class);
                startActivity(intent);
                finish();
            }
        });





        card1=(CardView)findViewById(R.id.c1);
        card2=(CardView)findViewById(R.id.c2);
        card3=(CardView)findViewById(R.id.c3);
        card4=(CardView)findViewById(R.id.c4);
        card5=(CardView)findViewById(R.id.c5);
        card6=(CardView)findViewById(R.id.c6);

        card1.setOnClickListener(this);
        card2.setOnClickListener(this);
        card3.setOnClickListener(this);
        card4.setOnClickListener(this);
        card5.setOnClickListener(this);
        card6.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent i;
        switch (view.getId()){
            case R.id.c1:
                i=new Intent (this,bookAppointment.class);
                startActivity(i);
                break;
            case R.id.c2:
                i=new Intent (this,caseHistoryP.class);
                startActivity(i);
                break;
            case R.id.c3:
                i=new Intent (this,transaction.class);
                startActivity(i);
                break;
            case R.id.c4:
                i=new Intent (this,ViewImageActivity.class);
                startActivity(i);
                break;
            case R.id.c5:
                i=new Intent (this,reports.class);
                startActivity(i);
                break;
            case R.id.c6:
//                i=new Intent (this,pharmacy.class);
//                startActivity(i);
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://pharmeasy.in/"));
                startActivity(browserIntent);
                break;


        }


    }

    public void signOut(View view){
        Intent intent = new Intent(patientSide.this,studentSignIn.class);
        startActivity(intent);
        finish();
    }
}