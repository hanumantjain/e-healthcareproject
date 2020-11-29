package com.example.try1;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class doctorSide extends AppCompatActivity implements View.OnClickListener {
    public CardView card1,card2,card3,card4,card5,card6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_side);
        getSupportActionBar().hide();

        card1=(CardView)findViewById(R.id.d1);
        card2=(CardView)findViewById(R.id.d2);
        card3=(CardView)findViewById(R.id.d3);
        card4=(CardView)findViewById(R.id.d4);
        card5=(CardView)findViewById(R.id.d5);
        card6=(CardView)findViewById(R.id.d6);

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
            case R.id.d1:
                i=new Intent (this,checkSchedule.class);
                startActivity(i);
                break;
            case R.id.d2:
                i=new Intent (this,keepNotes.class);
                startActivity(i);
                break;
            case R.id.d3:
                i=new Intent (this,statusReport.class);
                startActivity(i);
                break;
            case R.id.d4:
                i=new Intent (this,liveChat.class);
                startActivity(i);
                break;
            case R.id.d5:
//                i=new Intent (this,meetings.class);
////                startActivity(i);
////                break;
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://meet.google.com/"));
                startActivity(browserIntent);
                break;

            case R.id.d6:
//                i=new Intent (this,medicalOrder.class);
//                startActivity(i);
                browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.industrybuying.com/"));
                startActivity(browserIntent);
                break;


        }
    }

    public void signOut(View view){
        Intent intent = new Intent(doctorSide.this,doctorSignIn.class);
        startActivity(intent);
        finish();
    }
}