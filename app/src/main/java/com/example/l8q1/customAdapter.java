package com.example.l8q1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class customAdapter extends RecyclerView.Adapter<customAdapter.MyViewHolder> {
    private Context context;
    private ArrayList name,email,number;
    customAdapter(Context context, ArrayList name, ArrayList email, ArrayList number){
        this.context=context;
        this.name=name;
        this.email=email;
        this.number=number;

    }
    @NonNull
    @Override
    public customAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.row,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull customAdapter.MyViewHolder holder, int position) {
        holder.name.setText(String.valueOf(name.get(position)));
        holder.email.setText(String.valueOf(email.get(position)));
        holder.number.setText(String.valueOf(number.get(position)));
    }

    @Override
    public int getItemCount() {
        return name.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name,email,number;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.conName);
            email=itemView.findViewById(R.id.conEmail);
            number=itemView.findViewById(R.id.conPhone);

        }
    }
}
