package com.example.happypig.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.happypig.myapplication.Utilities.PageChange;
import com.example.happypig.myapplication.models.Pig;

import java.util.ArrayList;

public class SubMainActivity extends AppCompatActivity {

    static Button button;
    static EditText pigSearch;
    static ListView listview;
    static AppCompatActivity appContext;

    static String[] pigArray;
    static ArrayAdapter<String> arrayAdapter;
    static ArrayList<Pig> pigList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    private static void mapLayout(AppCompatActivity app){
        appContext = app;
        button = (Button) app.findViewById(R.id.testButton);
        pigSearch = (EditText) app.findViewById(R.id.pigsearch);
        listview = (ListView) app.findViewById(R.id.listview1);
    }

    private static void convertToArray(ArrayList<Pig> list, String[] array){
        for(int i = 0; i < list.size(); i++)
            array[i] = list.get(i).getName();
    }

    static void addController(AppCompatActivity app){
        mapLayout(app);

        Pig pig1 = new Pig("0001", "John");
        Pig pig2 = new Pig("0002", "Alex");
        Pig pig3 = new Pig("0003", "Wine");
        pigList = new ArrayList<>();
        pigList.add(pig1);
        pigList.add(pig2);
        pigList.add(pig3);

        pigArray = new String[pigList.size()];;
        convertToArray(pigList, pigArray);

        arrayAdapter = new ArrayAdapter<String>(appContext, R.layout.listview_content, R.id.textView, pigArray);
        listview.setAdapter(arrayAdapter);

        button.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                String pigName = pigSearch.getText().toString();
                //TODO : Search pigName in Database
                pigArray = new String[1];
                pigArray[0] = pigName;
                arrayAdapter = new ArrayAdapter<String>(appContext, R.layout.listview_content, R.id.textView, pigArray);
                listview.setAdapter(arrayAdapter);
            }
        });

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                PageChange.toPigstyActivity(appContext, pigList.get(position));
            }
        });


    }

}
