package com.example.happypig.myapplication;

import com.example.happypig.myapplication.models.Farm;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Yhingkai on 12/12/2017.
 */

public class FarmTest {

    @Test
    public void isConstructorWorkCorrectly(){
        String id = "1";
        String name = "MagicFarm";
        String tel = "0985265128";
        String email = "57050269@kmitl.ac.th";
        String password = "password";
        String pinOwn = "123456";

        Farm farm = new Farm(id,
                            name,
                            tel,
                            email,
                            password,
                            pinOwn);

        assertEquals(farm.getId(), id);
        assertEquals(farm.getName(), name);
        assertEquals(farm.getTel(), tel);
        assertEquals(farm.getEmail(), email);
        assertEquals(farm.getPassword(), password);
        assertEquals(farm.getPinOwn(), pinOwn);
    }

}
