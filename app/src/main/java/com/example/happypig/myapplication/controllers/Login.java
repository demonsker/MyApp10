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

public class Login {

    private static DBHandler handler = new DBHandler();

    public static int login(String username, String password){
        List<NameValuePair> params = new ArrayList<NameValuePair>();

        params.add(new BasicNameValuePair("strUser", username));
        params.add(new BasicNameValuePair("strPass", password));

        return handler.selectFarm(params);
    }

}
