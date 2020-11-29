package com.example.try1;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.Date;

public class checkSchedule extends AppCompatActivity {
    private TextView book11,book21,book31,book41,book51;
    private DatabaseReference database;
    private CardView appointD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_schedule);
        book11 = findViewById(R.id.book11);
        book21 = findViewById(R.id.book21);
        book31 = findViewById(R.id.book31);
        book41 = findViewById(R.id.book41);
        book51 = findViewById(R.id.book51);
        database = FirebaseDatabase.getInstance().getReference("patients").child("manu");
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy ");
        String currentDateandTime = sdf.format(new Date());
        book31.setText(currentDateandTime);

        appointD = (CardView) findViewById(R.id.appointD);

    }
    @Override
    protected void onStart() {
        super.onStart();
        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                UserHelperClass helperClass= snapshot.getValue(UserHelperClass.class);
                String id = helperClass.username;
                book11.setText(id);
                String NameN = helperClass.patientname;
                book21.setText(NameN);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void appointment(View view){
        Intent intent = new Intent(checkSchedule.this, checkSchedule2.class);
        startActivity(intent);
        Log.i("clicked","clicked");
    }

}