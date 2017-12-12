package com.example.happypig.myapplication.controllers;

import com.example.happypig.myapplication.Utilities.DBHandler;
import com.example.happypig.myapplication.models.Farm;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yhingkai on 12/12/2017.
 */

public class Action {

    private static DBHandler handler = new DBHandler();

    public static Farm login(String username, String password){
        List<NameValuePair> params = new ArrayList<NameValuePair>();

        params.add(new BasicNameValuePair("strUser", username));
        params.add(new BasicNameValuePair("strPass", password));

        return handler.selectFarm(params);
    }

    public static int register(Farm farm){
        List<NameValuePair> params = new ArrayList<NameValuePair>();

        params.add(new BasicNameValuePair("farmId", farm.getId()));
        params.add(new BasicNameValuePair("farmName", farm.getName()));
        params.add(new BasicNameValuePair("tell", farm.getTel()));
        params.add(new BasicNameValuePair("email", farm.getEmail()));
        params.add(new BasicNameValuePair("password", farm.getPassword()));
        params.add(new BasicNameValuePair("pinOwn", farm.getPinOwn()));

        return handler.insertFarm(params);
    }

}
