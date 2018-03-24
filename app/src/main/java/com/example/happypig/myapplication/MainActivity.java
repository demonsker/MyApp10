package com.example.happypig.myapplication;

import android.os.Bundle;
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
import android.widget.TextView;
import android.widget.Toast;

import com.example.happypig.myapplication.Utilities.PageChange;
import com.example.happypig.myapplication.Utilities.Session;
import com.example.happypig.myapplication.Utilities.Action;

import java.util.Random;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Session session;
    RelativeLayout layout;

    private int exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        layout = (RelativeLayout) findViewById(R.id.r1);

        session = new Session(getApplicationContext());
        if(session.isEmpty()){
            PageChange.toLoginActivity(this);
        }

        exit = 1;

        changeTab(R.layout.activity_sub_main,layout);

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
            changeTab(R.layout.activity_sub_main,layout);

        } else if (id == R.id.nav_sale) {
            changeTab(R.layout.activity_sale,layout);

        } else if (id == R.id.nav_food) {
            changeTab(R.layout.activity_food,layout);

        } else if (id == R.id.nav_environment) {
            changeTab(R.layout.activity_environment,layout);

        } else if (id == R.id.nav_finance) {
            changeTab(R.layout.activity_finance,layout);

        } else if (id == R.id.nav_report) {
            changeTab(R.layout.activity_report,layout);

        } else if (id == R.id.nav_notification) {
            changeTab(R.layout.activity_notification,layout);

        }
        else if (id == R.id.nav_logout) {
            session.clear();
            PageChange.toLoginActivity(this);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void changeTab(int activity, RelativeLayout layout){
        layout.removeAllViews();
        View content = getLayoutInflater().inflate(activity, layout, false);
        layout.addView(content);
        if(activity == R.layout.activity_sub_main)
            SubMainActivity.addController(this);
        else if(activity == R.layout.activity_food)
            FoodActivity.addController(this);
        else if(activity == R.layout.activity_finance)
            FinanceActivity.addController(this);
        else if(activity == R.layout.activity_environment) {
            EnvironmentActivity.addController(this);
            final TextView tempLabel = (TextView) findViewById(R.id.templabel);;

            final Random rand = new Random();
            (new Thread(new Runnable()
            {
                int count = 25;
                int status = 0;
                @Override
                public void run()
                {
                    tempLabel.setText("25 องศาเซลเซียส");
                    try {Thread.sleep(2000);}
                    catch(Exception e) {}

                    while (!Thread.interrupted())
                        try
                        {
                            runOnUiThread(new Runnable() // start actions in UI thread
                            {
                                @Override
                                public void run(){
                                    if(status == 0 && count <= 20) {
                                        status = 1;
                                        try {Thread.sleep(2000);}
                                        catch(Exception e) {}
                                    }
                                    int val = (rand.nextInt(1) + 1);
                                    count = (status == 0)? count-val : count+val;

                                    tempLabel.setText(count + " องศาเซลเซียส");
                                    if(count >= 24)
                                        try {Thread.sleep(2000);}
                                        catch(Exception e) {}

                                }
                            });
                            Thread.sleep(1500);
                        }
                        catch (InterruptedException e)
                        {
                            // ooops
                        }
                }
            })).start();
        }

    }

}
