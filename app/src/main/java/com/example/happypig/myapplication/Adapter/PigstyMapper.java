package com.example.happypig.myapplication.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


import com.example.happypig.myapplication.R;

public class PigstyMapper extends RecyclerView.ViewHolder {
    Button name;
    ImageView image;

    public PigstyMapper(View itemView) {
        super(itemView);

        name = (Button) itemView.findViewById(R.id.pigstyName);
        image = (ImageView) itemView.findViewById(R.id.pigstyPicture);
    }
}
