package com.example.happypig.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;

public class CleaningActivity extends AppCompatActivity {

    static Button cleanButton;
    static Button toTempButton;
    static Spinner BuildSpinner;
    static MainActivity appContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cleaning);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private static void mapLayout(MainActivity app){
        appContext = app;
        cleanButton = (Button) app.findViewById(R.id.cleanbutton);
        toTempButton = (Button) app.findViewById(R.id.totempbutton);
        BuildSpinner = (Spinner) app.findViewById(R.id.buildspinner);
    }

    static void addController(MainActivity app){
        mapLayout(app);

         //TODO : get size from DB
        int size = 5;
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for(int i = 1; i <= size; i++)
            arrayList.add(i);

        toTempButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                appContext.changTab(R.layout.activity_environment, appContext.layout);
                EnvironmentActivity.addController(appContext);
            }
        });


        ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer> (appContext, R.layout.build_spinner_list, R.id.testtextview, arrayList);
        BuildSpinner.setAdapter(adapter);

        BuildSpinner.setVisibility(View.VISIBLE);
        BuildSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
        public void onItemSelected(AdapterView<?> parent, View view, int position, long arg3) {


        }

        public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub}

        }

        });
    }
}
