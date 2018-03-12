package com.example.happypig.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.happypig.myapplication.models.Pig;

public class SubMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    static void addController(AppCompatActivity app){
        Button button = (Button) app.findViewById(R.id.testButton);
        button.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                System.out.println("Controller work!!");
            }
        });

        Pig pig1 = new Pig("0001", "John");
        Pig pig2 = new Pig("0002", "Alex");
        Pig pig3 = new Pig("0003", "Wine");

        final String[] pigList = new String[3];
        pigList[0] = pig1.getName();
        pigList[1] = pig2.getName();
        pigList[2] = pig3.getName();

        ListView listview = (ListView) app.findViewById(R.id.listview1);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(app, R.layout.listview_content, R.id.textView, pigList);
        listview.setAdapter(arrayAdapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                System.out.println(pigList[position]);
            }
        });
    }

}
