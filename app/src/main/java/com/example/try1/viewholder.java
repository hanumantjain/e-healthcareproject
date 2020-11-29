package com.example.try1;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class viewholder extends RecyclerView.ViewHolder {

    TextView amount,date;


    public viewholder(@NonNull View itemView) {
        super(itemView);
        amount = (TextView) itemView.findViewById(R.id.amount);
        date = (TextView) itemView.findViewById(R.id.date);
    }
}