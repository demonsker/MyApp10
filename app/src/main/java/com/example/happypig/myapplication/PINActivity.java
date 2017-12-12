package com.example.happypig.myapplication;

import android.content.Intent;
import android.graphics.pdf.PdfDocument;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.example.happypig.myapplication.Utilities.PageChange;
import com.example.happypig.myapplication.Utilities.Session;
import com.example.happypig.myapplication.controllers.Action;

public class PINActivity extends AppCompatActivity {

    private int exit;

    Session session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pin);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        exit = 1;
        session = new Session(getApplicationContext());
        if(session.getAuthen().equals("yes")){
            PageChange.toPigstyActivity(this);
        }
    }

    public  void  enterPinClick (View v)
    {
        //Backdoor
        session.setAuthen("yes");
        if(PageChange.toPigstyActivity(this))
            return;

        String pin = "";

        if(pin.equals(session.getPin())) {
            session.setAuthen("yes");
            PageChange.toPigstyActivity(this);
        }
        else{
            Toast.makeText(getApplicationContext(),"PIN ไม่ถูกต้อง",Toast.LENGTH_LONG).show();
        }
    }

    public  void  skipClick (View v)
    {
        PageChange.toMainActivity(this);
    }
    public  void  fabClick (View v) {
        PageChange.toAddActivity(this);
    }

    @Override
    public void onBackPressed() {
        if( exit-- == 0) {
            Action.exit(this);
        }
        else
            Toast.makeText(getApplicationContext(),"กดอีกครั้งเพื่อออกจากแอพพลิเคชัน",Toast.LENGTH_LONG).show();
    }

}
