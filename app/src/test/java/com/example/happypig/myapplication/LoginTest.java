package com.example.happypig.myapplication;

import com.example.happypig.myapplication.controllers.Login;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Yhingkai on 12/12/2017.
 */

public class LoginTest {

    @Test
    public void loginCorrectly() {
        String username = "kai";
        String password = "1234";
        assertEquals(Login.login(username,password),1);
    }
}
