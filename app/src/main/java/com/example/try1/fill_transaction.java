package com.example.try1;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class fill_transaction extends AppCompatActivity {

    private TextView mIdf, mPnamef, mPhonef, mEmailf, mDatef, mGenderf;
    private DatabaseReference database, data;
    private EditText dfeesf, tfeesf, lfeesf, mfeesf, totalf;
    private Button fillTransaction;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill_transaction);
        getSupportActionBar().hide();

        mIdf = findViewById(R.id.etidf);
        mPnamef = findViewById(R.id.etpnamef);
        mPhonef = findViewById(R.id.etphonef);
        mEmailf = findViewById(R.id.etdnamef);
        mDatef = findViewById(R.id.etdatef);
        mGenderf = findViewById(R.id.etGenderf);

        dfeesf = findViewById(R.id.dfeesf);
        tfeesf = findViewById(R.id.tfeest);
        lfeesf = findViewById(R.id.lfeesf);
        mfeesf = findViewById(R.id.mfessf);
        totalf = findViewById(R.id.totalf);
        fillTransaction = findViewById(R.id.savetransaction);

        database = FirebaseDatabase.getInstance().getReference("patients").child("manu");



        fillTransaction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = FirebaseDatabase.getInstance().getReference("transactions");
                String df = dfeesf.getEditableText().toString();
                String lf = lfeesf.getEditableText().toString();
                String tf = tfeesf.getEditableText().toString();
                String mf = mfeesf.getEditableText().toString();
                String tfee = totalf.getEditableText().toString();

                transactionhelp help = new transactionhelp(df,lf,tf,mf,tfee);
                data.child("1").setValue(help);
                finish();
                Toast.makeText(getBaseContext(), "Added SuccessFully" , Toast.LENGTH_SHORT ).show();

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                UserHelperClass helperClass= snapshot.getValue(UserHelperClass.class);
                String id = helperClass.username;
                mIdf.setText(id);
                String dob = helperClass.dob;
                mDatef.setText(dob);
                String sex = helperClass.sex;
                mGenderf.setText(sex);
                String NNN = helperClass.patientname;
                mPnamef.setText(NNN);
                String Phone = helperClass.phoneno;
                mPhonef.setText(Phone);
                String em1 = helperClass.email;
                mEmailf.setText(em1);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



    }


}