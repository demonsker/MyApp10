package com.example.happypig.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.example.happypig.myapplication.controllers.Action;

public class PigstyActivity extends AppCompatActivity {

    private int exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pigsty);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

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
