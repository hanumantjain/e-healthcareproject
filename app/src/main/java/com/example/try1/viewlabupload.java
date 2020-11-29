package com.example.try1;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class viewlabupload extends AppCompatActivity {

    ListView notesListView;
    DatabaseReference databaseReference;
    List<labreporthelperclass> mynotes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewlabupload);

        notesListView=(ListView)findViewById(R.id.notesView);
        mynotes =new ArrayList<>();


        viewAllFiles();

        notesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                labreporthelperclass labreporthelperclass=mynotes.get(i);

//                Intent intent=new Intent();
//                intent.setType(Intent.ACTION_VIEW);
//                intent.setData(Uri.parse(labreporthelperclass.getUrl()));
//                startActivity(intent);

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(labreporthelperclass.getUrl()));
                startActivity(intent);
            }
        });
    }

    private void viewAllFiles() {

        databaseReference= FirebaseDatabase.getInstance().getReference("statusReport");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for(DataSnapshot postSnapShot:dataSnapshot.getChildren()){
                    labreporthelperclass labreporthelperclass=postSnapShot.getValue(com.example.try1.labreporthelperclass.class);
                    mynotes.add(labreporthelperclass);

                }

                String[] uploads = new String[mynotes.size()];
                for(int i=0;i<uploads.length;i++){
                    uploads[i]=mynotes.get(i).getName();

                }

                ArrayAdapter<String> adapter=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,uploads){

                    @Override
                    public View getView(int position, View convertView, ViewGroup parent) {
                        View view =super.getView(position, convertView, parent);
                        TextView myText=(TextView) view.findViewById(android.R.id.text1);
                        myText.setTextColor(Color.BLUE);
                        return view;
                    }
                };
                notesListView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }




}