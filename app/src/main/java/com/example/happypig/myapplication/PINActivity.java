package com.example.happypig.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.example.happypig.myapplication.Utilities.PageChange;
import com.example.happypig.myapplication.Utilities.Session;

public class PINActivity extends AppCompatActivity {

    private int exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pin);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        exit = 1;
    }

    public  void  enterPinClick (View v)
    {
        //PageChange
        if(PageChange.toPigstyActivity(this))
            return;

        Session session = new Session(getApplicationContext());
        String pin = "";

        if(pin.equals(session.getPin())) {
            Intent intentdoor = new Intent(getBaseContext(), PigstyActivity.class);
            startActivity(intentdoor);
        }
        else{
            Toast.makeText(getApplicationContext(),"PIN ไม่ถูกต้อง",Toast.LENGTH_LONG).show();
        }
    }

    public  void  skipClick (View v)
    {
        Intent intentdoor = new Intent(getBaseContext(), MainActivity.class);
        startActivity(intentdoor);
    }
    public  void  fabClick (View v) {
        Intent intentdoor = new Intent(getBaseContext(), AddActivity.class);
        startActivity(intentdoor);
    }

    @Override
    public void onBackPressed() {
        if( exit-- == 0) {
            finish();
            System.exit(0);
        }
        else
            Toast.makeText(getApplicationContext(),"กดอีกครั้งเพื่อออกจากแอพพลิเคชัน",Toast.LENGTH_LONG).show();
    }

}
