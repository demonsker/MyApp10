package com.example.happypig.myapplication.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.happypig.myapplication.R;

public class PigstyMapper extends RecyclerView.ViewHolder {
    TextView name;

    public PigstyMapper(View itemView) {
        super(itemView);
        // get the reference of item view's
        name = (TextView) itemView.findViewById(R.id.pigstyName);
    }
}
