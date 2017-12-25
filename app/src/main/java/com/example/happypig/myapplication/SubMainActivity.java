package com.example.happypig.myapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.happypig.myapplication.Adapter.PigstyAdapter;
import com.example.happypig.myapplication.models.Pigsty;

import java.util.ArrayList;

public class SubMainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    GridLayoutManager gridLayoutManager;
    ArrayList<Pigsty> pigsty = new ArrayList<Pigsty>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_sub_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //create pigsty
        Pigsty person1 = new Pigsty("123456789","Prayuth");
        Pigsty person2 = new Pigsty("123456711","YhingLuk");
        Pigsty person3 = new Pigsty("123456711","Pom");
        //add pigsty
        pigsty.add(person1);
        pigsty.add(person2);
        pigsty.add(person3);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        gridLayoutManager = new GridLayoutManager(getApplicationContext(),2);

        showPigsty();
    }

    public void showPigsty(){
        recyclerView.setLayoutManager(gridLayoutManager); // set LayoutManager to RecyclerView

        PigstyAdapter pigstyAdapter = new PigstyAdapter(this, pigsty);
        recyclerView.setAdapter(pigstyAdapter);
    }
}
