package com.example.happypig.myapplication.models;

/**
 * Created by Yhingkai on 12/12/2017.
 */

public class Farm {

    private String id;

    private String name;

    private String tel;

    private String email;

    private String password;

    private String pinOwn;

    public Farm(){

    }

    public Farm(String id,
                String name,
                String tel,
                String email,
                String password,
                String pinOwn) {
        this.id = id;
        this.name = name;
        this.tel = tel;
        this.email = email;
        this.password = password;
        this.pinOwn = pinOwn;
    }

    public String toString(){
        return  this.id+
                this.name+
                this.tel+
                this.email+
                this.password+
                this.pinOwn;
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

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPinOwn() {
        return pinOwn;
    }

    public void setPinOwn(String pinOwn) {
        this.pinOwn = pinOwn;
    }

}
