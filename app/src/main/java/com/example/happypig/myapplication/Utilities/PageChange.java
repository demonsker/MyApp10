package com.example.happypig.myapplication.Utilities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import com.example.happypig.myapplication.*;

/**
 * Created by Yhingkai on 12/12/2017.
 */

public class PageChange {

    public static boolean toLoginActivity(AppCompatActivity page){
        Intent intentdoor = new Intent(page.getBaseContext(), LoginActivity.class);
        page.startActivity(intentdoor);
        return true;
    }

    public static boolean toPINActivity(AppCompatActivity page){
        Intent intentdoor = new Intent(page.getBaseContext(), PINActivity.class);
        page.startActivity(intentdoor);
        return true;
    }

    public static boolean toRegisterActivity(AppCompatActivity page){
        Intent intentdoor = new Intent(page.getBaseContext(), RegisterActivity.class);
        page.startActivity(intentdoor);
        return true;
    }

    public static boolean toPigstyActivity(AppCompatActivity page){
        Intent intentdoor = new Intent(page.getBaseContext(), PigstyActivity.class);
        page.startActivity(intentdoor);
        return true;
    }

    public static boolean toMainActivity(AppCompatActivity page){
        Intent intentdoor = new Intent(page.getBaseContext(), MainActivity.class);
        page.startActivity(intentdoor);
        return true;
    }

    public static boolean toAddActivity(AppCompatActivity page){
        Intent intentdoor = new Intent(page.getBaseContext(), AddActivity.class);
        page.startActivity(intentdoor);
        return true;
    }

    public static boolean toSubMainActivity(AppCompatActivity page){
        Intent intentdoor = new Intent(page.getBaseContext(), toSubMainActivity().class);
        page.startActivity(intentdoor);
        return true;
    }

}
