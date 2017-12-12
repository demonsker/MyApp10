package com.example.happypig.myapplication.Utilities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import com.example.happypig.myapplication.PINActivity;

/**
 * Created by Yhingkai on 12/12/2017.
 */

public class Backdoor {

    public static boolean toPINActivity(AppCompatActivity page){
        Intent intentdoor = new Intent(page.getBaseContext(), PINActivity.class);
        page.startActivity(intentdoor);
        return true;
    }

    public static boolean toPigstyActivity(AppCompatActivity page){
        Intent intentdoor = new Intent(page.getBaseContext(), PigstyActivity.class);
        page.startActivity(intentdoor);
        return true;
    }

}
