package com.example.happypig.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;

public class FoodActivity extends AppCompatActivity {

    static ImageView foodBalanceImage;
    static Button viewfoodDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    private static void mapLayout(AppCompatActivity app){
        foodBalanceImage = (ImageView) app.findViewById(R.id.foodbalanceimage);
        viewfoodDetail = (Button) app.findViewById(R.id.viewfooddetail);
    }

    static void addController(AppCompatActivity app){
        mapLayout(app);

        viewfoodDetail.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                foodBalanceImage.setImageResource(R.mipmap.ic_food_full);
            }
        });
    }
}

