package com.headfirst.designpatterns.chapter6;

public class GarageDoor {


    private String name;

    public GarageDoor(String name) {
        this.name = name;
    }

    public void up() {
        System.out.println("Garage door is up!");
    }
    public void down() {
        System.out.println("Garage door is down!");
    }
}
