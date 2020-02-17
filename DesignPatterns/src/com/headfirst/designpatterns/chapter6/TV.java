package com.headfirst.designpatterns.chapter6;

public class TV {

    private String name;

    public TV(String name) {
        this.name = name;
    }

    public void on() {
        System.out.println(name + " TV is on");
        System.out.println(name + " TV channel is set for DVD");
    }

    public void off() {
        System.out.println(name + " TV is off");
    }

}
