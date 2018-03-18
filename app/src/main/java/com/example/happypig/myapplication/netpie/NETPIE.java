package com.example.happypig.myapplication.netpie;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import io.netpie.microgear.Microgear;
import io.netpie.microgear.MicrogearEventListener;

public  class NETPIE {

    private static String appid;
    private static String key;
    private static String secret;
    private static String alias;
    private static Microgear microgear;
    private static MicrogearCallBack callback;
    private static Handler handler;

    public static void init(String _appid, String _key, String _secret){
        appid = _appid;
        key = _key;
        secret = _secret;
        callback = new MicrogearCallBack();
    }

    public static void setContext(AppCompatActivity context){
        microgear = new Microgear(context);
    }

    public static void setHandler(Handler _handler){
        handler = _handler;
    }

    public static void setAlias(String _alias){
        alias = _alias;
    }

    public static void connect(){
        microgear.connect(appid,key,secret,alias);
        microgear.setCallback(callback);
    }

    public static void sendMessage(String target, String message){
        microgear.chat(target, message);
    }

    static class MicrogearCallBack implements MicrogearEventListener {
        @Override
        public void onConnect() {
            Log.i("Connected","Now I'm connected with netpie");
        }

        @Override
        public void onMessage(String topic, String message) {
            Message msg = handler.obtainMessage();
            Bundle bundle = new Bundle();
            bundle.putString("myKey", message);
            msg.setData(bundle);
            handler.sendMessage(msg);
            Log.i("Message", message);
        }

        @Override
        public void onPresent(String token) {
            Log.i("present","New friend Connect :"+token);
        }

        @Override
        public void onAbsent(String token) {
            Log.i("absent","Friend lost :"+token);
        }

        @Override
        public void onDisconnect() {
            Log.i("disconnect","Disconnected");
        }

        @Override
        public void onError(String error) {
            Log.i("exception","Exception : "+error);
        }

        @Override
        public void onInfo(String info) {
            Log.i("info","Info : "+info);
        }
    }
}
