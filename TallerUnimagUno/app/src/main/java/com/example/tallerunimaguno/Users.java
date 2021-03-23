package com.example.tallerunimaguno;

import android.icu.lang.UScript;

public class Users {
    public String name;
    public String pass;

    public Users(){

    }

    public Users(String name, String pass){
        this.name = name;
        this.pass = pass;

    }

    public String getName() {
        return name;
    }

    public String getPass() {
        return pass;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

}




