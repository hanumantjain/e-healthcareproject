package com.example.try1;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.util.HashSet;

public class NoteEditorActivity extends AppCompatActivity
{
    int noteId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_editor);

        EditText editText =(EditText)findViewById(R.id.editText);

        Intent intent =getIntent();
        noteId= intent.getIntExtra("noteId",-1);
        if (noteId !=-1){
            editText.setText(keepNotes.notes.get(noteId));
        }else{
            keepNotes.notes.add("");
            noteId=keepNotes.notes.size() -  1;
            keepNotes.arrayAdapter.notifyDataSetChanged();


        }



        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                keepNotes.notes.set(noteId, String.valueOf( charSequence));
                keepNotes.arrayAdapter.notifyDataSetChanged();

                SharedPreferences sharedPreferences=getApplicationContext().getSharedPreferences("com.example.notes", Context.MODE_PRIVATE);
                HashSet<String> set =new HashSet(keepNotes.notes);
                sharedPreferences.edit().putStringSet("notes",set).apply();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });







    }
}