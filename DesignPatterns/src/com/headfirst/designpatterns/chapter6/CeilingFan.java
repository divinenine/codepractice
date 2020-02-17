package com.headfirst.designpatterns.chapter6;

public class CeilingFan {
    public static final int HIGH = 3;
    public static final int MEDIUM = 2;
    public static final int LOW = 1;
    public static final int OFF = 0;
    private String name;
    int speed;

    public CeilingFan(String name) {
        this.name = name;
        speed = OFF;

    }

    void high() {
        System.out.println(name + " ceiling fan is on high");
        speed = HIGH;
    }
    void medium() {
        System.out.println(name + " ceiling fan is on medium");
        speed = MEDIUM;
    }

    void low() {
        System.out.println(name + " ceiling fan is on low");
        speed = LOW;
    }

    void on() {
        System.out.println(name + " ceiling fan is rotating and cooling!");
    }

    void off() {
        speed = OFF;
        System.out.println(name + " ceiling Fan is stopping...");
    }

    public int getSpeed() {
        return speed;
    }

}
