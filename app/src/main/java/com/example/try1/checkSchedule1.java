package com.example.try1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class checkSchedule1 extends AppCompatActivity {
    private ArrayList<checkSchedule_User>usersList;
    private RecyclerView recyclerView;
    private checkSchedule_recyclerAdapter.RecyclerViewClickListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_schedule1);
        recyclerView=findViewById(R.id.recyclerview);
        usersList=new ArrayList<>();

        setUserInfo();
        setAdapter();
    }

    private void setAdapter() {
        setOnclicklistner();
        checkSchedule_recyclerAdapter adapter=new checkSchedule_recyclerAdapter(usersList,listener);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    private void setOnclicklistner() {
        listener=new checkSchedule_recyclerAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View v, int position) {
                Intent intent =new Intent(getApplicationContext(),checkSchedule2.class);
                intent.putExtra("patientName",usersList.get(position).getUsername());
                startActivity(intent);
            }
        };
    }

    private void setUserInfo() {
        usersList.add(new checkSchedule_User ("Shanmukh"));
        usersList.add(new checkSchedule_User("Anukul"));
        usersList.add(new checkSchedule_User("Priti"));
        usersList.add(new checkSchedule_User("Hanumant"));
    }
}