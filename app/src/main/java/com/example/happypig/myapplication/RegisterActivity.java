package com.example.happypig.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.happypig.myapplication.controllers.Action;
import com.example.happypig.myapplication.models.Farm;

public class RegisterActivity extends AppCompatActivity {
    EditText farmName;
    EditText tell;
    EditText email;
    EditText password;
    EditText confirmPasword;
    EditText pin;
    Button registerButton;
    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        farmName = (EditText) findViewById(R.id.farmname);
        tell = (EditText) findViewById(R.id.tell);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        confirmPasword = (EditText) findViewById(R.id.confirmPassword);
        pin = (EditText) findViewById(R.id.PIN);
        registerButton = (Button) findViewById(R.id.Register_Button);
        loginButton = (Button) findViewById(R.id.goto_login_Button);
    }

    public  void  RegisterClick (View v)
    {
        if(password.getText().toString().equals(confirmPasword.getText().toString()))
        {
            Farm farm = new Farm("",
                                farmName.getText().toString(),
                                tell.getText().toString(),
                                email.getText().toString(),
                                password.getText().toString(),
                                pin.getText().toString());

            if(Action.register(farm)==1){
                Intent intentdoor = new Intent(getBaseContext(), LoginActivity.class);
                startActivity(intentdoor);
            }

        }
        else
        {
            password.setText("");
            confirmPasword.setText("");
        }

    }

    public  void  gotoLoginClick (View v)
    {
        Intent intentdoor = new Intent(getBaseContext(), LoginActivity.class);
        startActivity(intentdoor);
    }

}
