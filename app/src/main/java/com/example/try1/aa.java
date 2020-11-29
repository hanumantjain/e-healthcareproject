package com.example.try1;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class aa extends AppCompatActivity {
    private ImageView aaa;
    private DatabaseReference database;
    TextView iv_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aa);

        aaa = findViewById(R.id.aaa);
        iv_result = findViewById(R.id.iv_result);
        database = FirebaseDatabase.getInstance().getReference("ClinicalReports").child("BloodReport");

    }

    @Override
    protected void onStart() {
        super.onStart();
        database.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                UploadClinicalData data = snapshot.getValue(UploadClinicalData.class);

                String url = data.toString();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

}

