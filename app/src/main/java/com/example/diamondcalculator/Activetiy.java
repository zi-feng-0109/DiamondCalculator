package com.example.diamondcalculator;

public class Activetiy {
    private String time;
    private String name;
    private int value;
    Activetiy(String name,String time,int value){
        this.name=name;
        this.time=time;
        this.value=value;
    }
    public int getValue(){
        return value;
    }
    public String getTime(){
        return time;
    }
}
