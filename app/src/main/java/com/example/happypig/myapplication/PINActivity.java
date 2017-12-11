package com.example.happypig.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class PINActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pin);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }

    public  void  enterPinClick (View v)
    {
        Intent intentdoor = new Intent(getBaseContext(), PigstyActivity.class);
        startActivity(intentdoor);
    }

    public  void  skipClick (View v)
    {
        Intent intentdoor = new Intent(getBaseContext(), MainActivity.class);
        startActivity(intentdoor);
    }
    public  void  fabClick (View v) {
        Intent intentdoor = new Intent(getBaseContext(), AddActivity.class);
        startActivity(intentdoor);
    }

}
