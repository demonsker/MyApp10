package com.example.happypig.myapplication.models;

/**
 * Created by Eucliwood on 13-Mar-18.
 */

public class Pig {

    private String id;

    private String name;

    public Pig(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
