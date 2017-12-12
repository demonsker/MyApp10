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

    public void setId(String id) {
        prefs.edit().putString("id", id).commit();
    }

    public String getId() {
        String id = prefs.getString("id","");
        return id;
    }

    public void setName(String name) {
        prefs.edit().putString("name", name).commit();
    }

    public String getName() {
        String name = prefs.getString("name","");
        return name;
    }

    public void setTel(String tel){
        prefs.edit().putString("tel", tel).commit();
    }

    public String getTel() {
        String tel = prefs.getString("tel","");
        return tel;
    }

    public void setEmail(String email){
        prefs.edit().putString("Email", email).commit();
    }

    public String getEmail() {
        String email = prefs.getString("email","");
        return email;
    }

    public void setPassword(String password){
        prefs.edit().putString("password", password).commit();
    }

    public String getPassword() {
        String password = prefs.getString("password","");
        return password;
    }

    public void setPin(String pin){
        prefs.edit().putString("pin", pin).commit();
    }

    public String getPin() {
        String pin= prefs.getString("pin","");
        return pin;
    }

    public boolean isEmpty(){
        String id = getId();
        if(id.equals(""))
            return true;
        else
            return false;
    }

    public void clear(){
        prefs.edit().putString("id", "").commit();
    }

}
