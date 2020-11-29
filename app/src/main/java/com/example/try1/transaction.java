package com.example.try1;



import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class transaction extends AppCompatActivity {

    RecyclerView recyclerView;
    myadapter myadapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction);
        getSupportActionBar().hide();

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        myadapter = new myadapter(dequeue(), getApplicationContext());
        recyclerView.setAdapter(myadapter);
    }


    public ArrayList<model> dequeue() {
        ArrayList<model> holder = new ArrayList<>();

        model ob1 = new model();
        ob1.setDate("5 September 2020");
        ob1.setAmount("$ 400");
        holder.add(ob1);


        model ob2 = new model();
        ob2.setDate("20 July 2020");
        ob2.setAmount("$ 320");
        holder.add(ob2);

        model ob3 = new model();
        ob3.setDate("01 July 2020");
        ob3.setAmount("$ 420");
        holder.add(ob3);

        return holder;

    }


}