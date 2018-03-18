package com.example.happypig.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Button;

import com.example.happypig.myapplication.Utilities.PigDataSender;


public class PigstyActivity extends AppCompatActivity {

    Button pigName;

    PigDataSender pigSender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pigsty);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        pigName = (Button) findViewById(R.id.pigname);
        pigSender = new PigDataSender(getApplicationContext());

        pigName.setText("ชื่อ : "+pigSender.getName());
    }

}
