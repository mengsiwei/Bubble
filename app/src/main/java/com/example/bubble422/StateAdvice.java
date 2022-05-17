package com.example.bubble422;

public class StateAdvice {
    public StateAdvice(int state_img, String state_name){
        this.state_img=state_img;
        this.state_name=state_name;
    }

    private int state_img;
    private String state_name;

    public int getState_img(){
        return state_img;
    }
    public void setState_img(int state_img){
        this.state_img=state_img;
    }

    public String getState_name(){
        return state_name;
    }
    public void setState_name(String state_name){
        this.state_name=state_name;
    }

}
