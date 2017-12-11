package com.example.happypig.myapplication.Utilities;

import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yhingkai on 12/12/2017.
 */

public class DBHandler {

    public  int insertFarm(){
        String url = "http://192.168.1.5/register.php";
        List<NameValuePair> params = new ArrayList<NameValuePair>();

        params.add(new BasicNameValuePair("farmId", "1"));
        params.add(new BasicNameValuePair("farmName", farmName.getText().toString()));
        params.add(new BasicNameValuePair("tell", tell.getText().toString()));
        params.add(new BasicNameValuePair("email", email.getText().toString()));
        params.add(new BasicNameValuePair("password", password.getText().toString()));
        params.add(new BasicNameValuePair("pinOwn", pin.getText().toString()));

        String resultServer  = getHttpPost(url,params);
        JSONObject c;

        String strStatusID = "0";

        try {
            c = new JSONObject(resultServer);
            strStatusID = c.getString("StatusID");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        if(strStatusID.equals("1"))
            return 1;
        else
            return 0;
    }

    public String getHttpPost(String url,List<NameValuePair> params) {
        StringBuilder str = new StringBuilder();
        HttpClient client = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(url);

        try {
            httpPost.setEntity(new UrlEncodedFormEntity(params));
            HttpResponse response = client.execute(httpPost);
            StatusLine statusLine = response.getStatusLine();
            int statusCode = statusLine.getStatusCode();
            if (statusCode == 200) { // Status OK
                HttpEntity entity = response.getEntity();
                InputStream content = entity.getContent();
                BufferedReader reader = new BufferedReader(new InputStreamReader(content));
                String line;
                while ((line = reader.readLine()) != null) {
                    str.append(line);
                }
            } else {
                Log.e("Log", "Failed to download result..");
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str.toString();

    }

}
