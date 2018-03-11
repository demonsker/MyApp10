package com.example.happypig.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class SubMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    static void run(AppCompatActivity app){
        Button button = (Button) app.findViewById(R.id.testButton);
        button.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                System.out.println("Controller work!!");
            }
        });

        ListView listview = (ListView) app.findViewById(R.id.listview1);
        String countryList[] = {"India", "China", "australia", "Portugle", "America", "NewZealand"};
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(app, R.layout.listview_content, R.id.textView, countryList);
        listview.setAdapter(arrayAdapter);

    }

}
