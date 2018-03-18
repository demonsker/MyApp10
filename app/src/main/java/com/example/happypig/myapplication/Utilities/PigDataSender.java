package com.example.happypig.myapplication.Utilities;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class PigDataSender {

    private SharedPreferences prefs;

    public PigDataSender(Context cntx) {
        // TODO Auto-generated constructor stub
        prefs = PreferenceManager.getDefaultSharedPreferences(cntx);
    }

    public void setName(String name) {
        prefs.edit().putString("pigname", name).commit();
    }

    public String getName() {
        String name = prefs.getString("pigname","");
        return name;
    }
}
