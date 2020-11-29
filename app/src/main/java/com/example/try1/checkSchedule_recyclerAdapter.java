package com.example.try1;



import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class checkSchedule_recyclerAdapter extends RecyclerView.Adapter<checkSchedule_recyclerAdapter.MyViewHolder> {
    private ArrayList<checkSchedule_User> usersList;
    private RecyclerViewClickListener listener;

    public checkSchedule_recyclerAdapter(ArrayList<checkSchedule_User> usersList,RecyclerViewClickListener listener){
        this.usersList=usersList;
        this.listener=listener;
    }
    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView nameTxt;
        public MyViewHolder(final View view){
            super(view);
            nameTxt=view.findViewById(R.id.textview1);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            listener.onClick(view,getAdapterPosition());

        }
    }
    @NonNull
    @Override
    public checkSchedule_recyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.checkschedule_list_item,parent,false);
        return  new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull checkSchedule_recyclerAdapter.MyViewHolder holder, int position) {
        String name =usersList.get(position).getUsername();
        holder.nameTxt.setText(name);
    }

    @Override
    public int getItemCount() {
        return usersList.size();
    }
    public interface RecyclerViewClickListener{
        void onClick(View v,int position);
    }
}

