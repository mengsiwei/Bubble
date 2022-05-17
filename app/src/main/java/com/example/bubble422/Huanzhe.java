package com.example.bubble422;

import android.widget.Button;

public class Huanzhe {
    public Huanzhe(int huanzhe_image, String huanzhe_name, String huanzhe_state, String huanzhe_face, String huanzhe_xinqing){
        this.huanzhe_image=huanzhe_image;
        this.huanzhe_name=huanzhe_name;
        this.huanzhe_state=huanzhe_state;
        this.huanzhe_face=huanzhe_face;
        this.huanzhe_xinqing=huanzhe_xinqing;
    }

    private int huanzhe_image;
    private String huanzhe_name;
    private String huanzhe_state;
    private String huanzhe_face;
    private String huanzhe_xinqing;

    public int getHuanzhe_image(){
        return huanzhe_image;
    }
    public void setHuanzhe_image(int huanzhe_image){
        this.huanzhe_image=huanzhe_image;
    }

    public String getHuanzhe_name(){
        return huanzhe_name;
    }
    public void setHuanzhe_name(String huanzhe_name){
        this.huanzhe_name=huanzhe_name;
    }

    public String getHuanzhe_state(){
        return huanzhe_state;
    }
    public void setHuanzhe_state(String huanzhe_state){
        this.huanzhe_state=huanzhe_state;
    }

    public String getHuanzhe_face(){
        return huanzhe_face;
    }
    public void setHuanzhe_face(String huanzhe_face){
        this.huanzhe_face=huanzhe_face;
    }

    public String getHuanzhe_xinqing(){
        return huanzhe_xinqing;
    }
    public void setHuanzhe_xinqing(String huanzhe_xinqing){
        this.huanzhe_xinqing=huanzhe_xinqing;
    }
}
