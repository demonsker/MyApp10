package com.example.happypig.myapplication.models;

import java.io.Serializable;

/**
 * Created by EucliwoodX on 24-Dec-17.
 */

public class Pigsty implements Serializable {

    private String id;
    private String name;

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
