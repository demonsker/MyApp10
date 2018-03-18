package com.example.happypig.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class FinanceActivity extends AppCompatActivity {

    static AppCompatActivity appContext;

    static Button testButton;
    static Spinner testSpinner;
    static EditText testValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finance);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private static void mapLayout(AppCompatActivity app){
        appContext = app;
        testValue = (EditText) app.findViewById(R.id.testvalue);
        testButton = (Button) app.findViewById(R.id.testbutton);
        testSpinner = (Spinner) app.findViewById(R.id.testspinner);
    }

    static void addController(AppCompatActivity app){
        mapLayout(app);

        testButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                int size = Integer.parseInt(testValue.getText().toString());
                ArrayList<Integer> arrayList = new ArrayList<Integer>();
                for(int i = 1; i <= size; i++)
                    arrayList.add(i);

                ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer> (appContext, R.layout.test_spinner_list, R.id.testtextview, arrayList);
                testSpinner.setAdapter(adapter);

                testSpinner.setVisibility(View.VISIBLE);
                testSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
                {
                    public void onItemSelected(AdapterView<?> parent, View view,
                                               int position, long arg3)
                    {


                    }

                    public void onNothingSelected(AdapterView<?> arg0)
                    {
                        // TODO Auto-generated method stub
                    }

                });
            }
        });
    }
}
