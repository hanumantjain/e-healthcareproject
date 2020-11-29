package com.example.try1;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.Date;

public class showBookedAppoitment extends AppCompatActivity {
    private TextView book1,book2,book3,book4,book5;
    private DatabaseReference database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_booked_appoitment);
        book1 = findViewById(R.id.book1);
        book2 = findViewById(R.id.book2);
        book3 = findViewById(R.id.book3);
        book4 = findViewById(R.id.book4);
        book5 = findViewById(R.id.book5);
        database = FirebaseDatabase.getInstance().getReference("patients").child("manu");
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy ");
        String currentDateandTime = sdf.format(new Date());
        book3.setText(currentDateandTime);

    }
    @Override
    protected void onStart() {
        super.onStart();
        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                UserHelperClass helperClass= snapshot.getValue(UserHelperClass.class);
                String id = helperClass.username;
                book1.setText(id);
                String NameN = helperClass.patientname;
                book2.setText(NameN);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}