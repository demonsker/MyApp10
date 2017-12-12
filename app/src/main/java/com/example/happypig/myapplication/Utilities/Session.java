package com.example.happypig.myapplication.Utilities;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by Yhingkai on 12/12/2017.
 */

public class Session {

    private SharedPreferences prefs;

    public Session(Context cntx) {
        // TODO Auto-generated constructor stub
        prefs = PreferenceManager.getDefaultSharedPreferences(cntx);
    }

    public void setUserName(String userName) {
        prefs.edit().putString("userName", userName).commit();
    }

    public String getUserName() {
        String userName = prefs.getString("userName","");
        return userName;
    }

}
