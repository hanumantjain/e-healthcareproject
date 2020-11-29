package com.example.try1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class loginAs extends AppCompatActivity {
    private Button moveToAdmin, moveToStudents;
    private TextView tv_aboutus, tv_healthtips;
    private Button covidStat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_as);
        getSupportActionBar().hide();

        tv_aboutus = findViewById(R.id.tv_aboutus);

        tv_aboutus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(loginAs.this,AboutUs.class);
                startActivity(intent);
            }
        });

        tv_healthtips = findViewById(R.id.tv_healthtips);
        tv_healthtips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(loginAs.this,HealthTips.class);
                startActivity(intent);
            }
        });

        covidStat = findViewById(R.id.covidStat);
        covidStat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(loginAs.this, CovidStats.class);
                startActivity(intent);
            }
        });

        moveToAdmin = findViewById(R.id.log_admin);
        moveToAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveToAdminPage();
            }
        });

        moveToStudents=findViewById(R.id.log_student);
        moveToStudents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveToStudentPage();
            }
        });
    }
    private void moveToAdminPage(){
        Intent intent=new Intent(loginAs.this,doctorSignIn.class);
        startActivity(intent);
    }

        private void moveToStudentPage(){
        Intent intent=new Intent(loginAs.this,studentSignIn.class);
        startActivity(intent);
    }
}