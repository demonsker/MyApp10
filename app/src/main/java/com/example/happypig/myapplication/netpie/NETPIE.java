package com.example.happypig.myapplication.netpie;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import io.netpie.microgear.Microgear;
import io.netpie.microgear.MicrogearEventListener;

public class NETPIE {

    private String appid;
    private String key;
    private String secret;
    private String alias;
    private Microgear microgear;
    private MicrogearCallBack callback;
    private Handler handler;

    public NETPIE(String appid, String key, String secret){
        this.appid = appid;
        this.key = key;
        this.secret = secret;
        callback = new MicrogearCallBack();
    }

    public void setContext(AppCompatActivity context){
        this.microgear = new Microgear(context);
    }

    public void setHandler(Handler handler){
        this.handler = handler;
    }

    public void setAlias(String alias){
        this.alias = alias;
    }

    public void connect(){
        microgear.connect(appid,key,secret,alias);
        microgear.setCallback(callback);
    }

    public void sendMessage(String target, String message){
        microgear.chat(target, message);
    }

    protected void onDestroy() {
        microgear.disconnect();
    }

    protected void onResume() {
        microgear.bindServiceResume();
    }

    class MicrogearCallBack implements MicrogearEventListener {
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
