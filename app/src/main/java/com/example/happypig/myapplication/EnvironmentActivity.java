package com.example.happypig.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.happypig.myapplication.Utilities.Action;


public class EnvironmentActivity extends AppCompatActivity {

    static Button toCleanButton;
    static Button toSetTempButton;
    static Button setTempButton;
    static EditText minTemp;
    static EditText maxTemp;
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
        toSetTempButton = (Button) app.findViewById(R.id.tosettempbutton);
    }

    static void addController(MainActivity app) {
        mapLayout(app);


        toCleanButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                appContext.changeTab(R.layout.activity_cleaning, appContext.layout);
                CleaningActivity.addController(appContext);
            }
        });

        toSetTempButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                appContext.changeTab(R.layout.activity_temperature_setting, appContext.layout);

                setTempButton = (Button) appContext.findViewById(R.id.settempbutton);
                minTemp = (EditText) appContext.findViewById(R.id.mintemp);
                maxTemp = (EditText) appContext.findViewById(R.id.maxtemp);

                setTempButton.setOnClickListener(new Button.OnClickListener() {
                    public void onClick(View v) {
                        double min = Double.parseDouble(minTemp.getText().toString());
                        double max = Double.parseDouble(maxTemp.getText().toString());
                        if(Action.setTemperature(appContext, min, max) == 1)
                            Toast.makeText(appContext,"ตั้งอุณหภูมิสำเร็จ",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(appContext,"มีข้อผิดพลาดเกิดขึ้น",Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

    }
}
