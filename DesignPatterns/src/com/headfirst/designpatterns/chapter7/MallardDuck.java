package com.headfirst.designpatterns.chapter7;

public class MallardDuck implements Duck {
    @Override
    public void quack() {
        System.out.println("Quaaack!");
    }

    @Override
    public void fly() {
        System.out.println("I'm flying!");
    }
}
