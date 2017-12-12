package com.example.happypig.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.example.happypig.myapplication.controllers.Action;

import android.view.View;


public class PigstyActivity extends AppCompatActivity {

    private int exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pigsty);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        exit = 1;
    }

    @Override
    public void onBackPressed() {
        if( exit-- == 0) {
            Action.exit(this);
        }
        else
            Toast.makeText(getApplicationContext(),"กดอีกครั้งเพื่อออกจากแอพพลิเคชัน",Toast.LENGTH_LONG).show();
    }

}
