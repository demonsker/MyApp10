package com.example.happypig.myapplication.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.happypig.myapplication.models.Pigsty;

import java.util.ArrayList;

public class PigstyAdapter extends RecyclerView.Adapter<PigstyMapper> {

    ArrayList<Pigsty> person;
    Context context;

    public PigstyAdapter(Context context, ArrayList person) {
        this.context = context;
        this.person = person;
    }
    @Override
    public PigstyMapper onCreateViewHolder(ViewGroup parent, int viewType) {
        // infalte the item Layout
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rowlayout, parent, false);
        // set the view's size, margins, paddings and layout parameters
        PigstyMapper vh = new PigstyMapper(v); // pass the view to View Holder
        return vh;
    }
    @Override
    public void onBindViewHolder(PigstyMapper holder, final int position) {
        holder.name.setText(((Pigsty) person.get(position)).getName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentdoor = new Intent(context, ShowGeneralActivity.class);
                intentdoor.putExtra("general", person.get(position));
                context.startActivity(intentdoor);
                //Toast.makeText(context,((Person) person.get(position)).getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    @Override
    public int getItemCount() {
        return person.size();
    }
}
