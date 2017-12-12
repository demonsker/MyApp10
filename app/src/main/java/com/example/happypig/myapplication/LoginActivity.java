package com.example.happypig.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.happypig.myapplication.Utilities.PageChange;
import com.example.happypig.myapplication.Utilities.Session;
import com.example.happypig.myapplication.controllers.Action;
import com.example.happypig.myapplication.models.Farm;

public class LoginActivity extends AppCompatActivity {

    EditText userName;
    EditText password;
    Button loginButton;
    Button registerButton;

    Session session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Permission StrictMode
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        userName = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password_login);
        loginButton = (Button) findViewById(R.id.login_Button);
        registerButton = (Button) findViewById(R.id.goto_Register_Button);

        session = new Session(getApplicationContext());
        if(!session.isEmpty()){
            PageChange.toPINActivity(this);
        }
    }

    public  void  gotoRegisterClick (View v)
    {
        Intent intentdoor = new Intent(getBaseContext(), RegisterActivity.class);
        startActivity(intentdoor);
    }

    public void loginClick (View v)
    {
        //BackDoor
        //if(PageChange.toPINActivity(this))
           // return;

        String usr = userName.getText().toString();
        String pwd = password.getText().toString();

        Farm farm = Action.login(usr,pwd);

        if(!farm.toString().equals("")) {
            session.setId(farm.getId());
            session.setName(farm.getName());
            session.setTel(farm.getTel());
            session.setEmail(farm.getEmail());
            session.setPassword(farm.getPassword());
            session.setPin(farm.getPinOwn());

            PageChange.toPINActivity(this);
        }
        else
            Toast.makeText(getApplicationContext(),"ไม่พบผู้ใช้งานหรือรหัสผ่านไม่ถูกต้อง",Toast.LENGTH_LONG).show();
    }

}



