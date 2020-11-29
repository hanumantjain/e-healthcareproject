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

public class transaction_1 extends AppCompatActivity {

    private TextView mId, mPname, mPhone, mEmail, mDate, mGender;
    private DatabaseReference database, data;
    private TextView doctorFee1, treatFee1, misFee1, labFee1, totalFee1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction_1);
        getSupportActionBar().hide();

        mId = findViewById(R.id.etid);
        mPname = findViewById(R.id.etpname);
        mPhone = findViewById(R.id.etphone);
        mEmail = findViewById(R.id.etdname);
        mDate = findViewById(R.id.etdate);
        mGender = findViewById(R.id.etGender);

        doctorFee1 = findViewById(R.id.doctorFee1);
        treatFee1 = findViewById(R.id.treatFee1);
        misFee1 = findViewById(R.id.missFee1);
        labFee1 = findViewById(R.id.labFee1);
        totalFee1 = findViewById(R.id.totalFee1);

        database = FirebaseDatabase.getInstance().getReference("patients").child("manu");
        data = FirebaseDatabase.getInstance().getReference("transactions").child("1");

    }

    @Override
    protected void onStart() {
        super.onStart();
        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                UserHelperClass helperClass= snapshot.getValue(UserHelperClass.class);
                String id = helperClass.username;
                mId.setText(id);
                String dob = helperClass.dob;
                mDate.setText(dob);
                String sex = helperClass.sex;
                mGender.setText(sex);
                String NNN = helperClass.patientname;
                mPname.setText(NNN);
                String Phone = helperClass.phoneno;
                mPhone.setText(Phone);
                String Email = helperClass.email;
                mEmail.setText(Email);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        super.onStart();
        data.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                transactionhelp help1 = dataSnapshot.getValue(transactionhelp.class);
                String df1 = help1.doctorf;
                doctorFee1.setText(df1);
                String lf1 = help1.labf;
                labFee1.setText(lf1);
                String mf1 = help1.misf;
                misFee1.setText(mf1);
                String tf1 = help1.treatf;
                treatFee1.setText(tf1);
                String ttf1 = help1.totalfee;
                totalFee1.setText(ttf1);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}