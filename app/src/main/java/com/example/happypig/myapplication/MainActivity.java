package com.example.happypig.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.happypig.myapplication.Adapter.PigstyAdapter;
import com.example.happypig.myapplication.Utilities.PageChange;
import com.example.happypig.myapplication.Utilities.Session;
import com.example.happypig.myapplication.controllers.Action;
import com.example.happypig.myapplication.models.Pigsty;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Session session;
    RelativeLayout layout;
    private int exit;
    ArrayList<Pigsty> pigsty = new ArrayList<Pigsty>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentdoor = new Intent(getBaseContext(), AddActivity.class);
                startActivity(intentdoor);
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        layout = (RelativeLayout) findViewById(R.id.r1);

        //create pigsty
        Pigsty person1 = new Pigsty("123456789","Prayuth");
        Pigsty person2 = new Pigsty("123456711","YhingLuk");
        //add pigsty
        pigsty.add(person1);
        pigsty.add(person2);


        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),2);
        recyclerView.setLayoutManager(gridLayoutManager); // set LayoutManager to RecyclerView

        PigstyAdapter pigstyAdapter = new PigstyAdapter(this, pigsty);
        recyclerView.setAdapter(pigstyAdapter);

        session = new Session(getApplicationContext());
        if(session.isEmpty()){
            PageChange.toLoginActivity(this);
        }

        exit = 1;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
        else {
            if (exit-- == 0)
                Action.exit(this);
            else
                Toast.makeText(getApplicationContext(), "กดอีกครั้งเพื่อออกจากแอพพลิเคชัน", Toast.LENGTH_LONG).show();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main22, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.nav_home) {
            layout.removeAllViews();

        } else if (id == R.id.nav_sale) {

        } else if (id == R.id.nav_food) {
            changTab(R.layout.activity_food,layout);

        } else if (id == R.id.nav_environment) {
            changTab(R.layout.activity_environment,layout);

        } else if (id == R.id.nav_finance) {

        } else if (id == R.id.nav_report) {

        } else if (id == R.id.nav_logout) {
            session.clear();
            PageChange.toLoginActivity(this);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void changTab(int activity, RelativeLayout layout){
        layout.removeAllViews();
        View content = getLayoutInflater().inflate(activity, layout, false);
        layout.addView(content);
    }



}
