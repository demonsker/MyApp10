package com.example.happypig.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Spinner;

import com.example.happypig.myapplication.Utilities.PageChange;

public class EnvironmentActivity extends AppCompatActivity {

    static Button toCleanButton;
    static Button setTempButton;
    static MainActivity appContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_environment);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private static void mapLayout(final MainActivity app){
        appContext = app;
        toCleanButton = (Button) app.findViewById(R.id.tocleanbutton);
        setTempButton = (Button) app.findViewById(R.id.setTemp_Button);
    }

    static void addController(MainActivity app) {
        mapLayout(app);

        toCleanButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                appContext.changTab(R.layout.activity_cleaning, appContext.layout);
                CleaningActivity.addController(appContext);
            }
        });

        setTempButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                appContext.changTab(R.layout.activity_temperature_setting, appContext.layout);
            }
        });
    }
}
