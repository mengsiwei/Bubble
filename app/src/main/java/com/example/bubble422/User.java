package com.example.bubble422;

import java.io.Serializable;

public class User implements Serializable{
    private int id;
    private String username;
    private String userphone;
    private String password;
    public User() {
        super();
        // TODO Auto-generated constructor stub
    }
    public User(int id,String username, String password, String userphone) {
        super();
        this.id=id;
        this.username = username;
        this.userphone=userphone;
        this.password = password;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getUserphone() {
        return userphone;
    }
    public void setUserphone(String userphone) {
        this.userphone = userphone;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + ", userphone=" + userphone + ", password=" + password + "]";
    }

}


