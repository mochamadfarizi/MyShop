package org.online.myshopfirebase.model;

import android.content.Context;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.Serializable;

public class user implements Serializable {
    private String name;
    private  String password;
    private String role;
    private String key;

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    private String confirmPassword;

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setKey(String key) {
        this.key = key;
    }
    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public String getKey() {
        return key;
    }

    public user(String nm, String pass,String con, String rl){
        name = nm;
        password = pass;
        confirmPassword=con;
        role = rl;
    }



}
