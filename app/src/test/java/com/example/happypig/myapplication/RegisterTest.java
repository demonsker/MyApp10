package com.example.happypig.myapplication;

import com.example.happypig.myapplication.controllers.Register;
import com.example.happypig.myapplication.models.Farm;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Yhingkai on 12/12/2017.
 */

public class RegisterTest {

    Farm farm = new Farm("999999",
                        "MagicFarm",
                        "0985265128",
                        "57050269@kmitl.ac.th",
                        "password",
                        "123456");

    @Test
    public void InsertFarmCorrectly() {
        assertEquals(Register.addFarm(farm), 1);
    }

}
