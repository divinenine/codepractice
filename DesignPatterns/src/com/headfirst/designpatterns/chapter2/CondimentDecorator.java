package com.headfirst.designpatterns.chapter2;

public abstract class CondimentDecorator extends Beverage {

    public Beverage beverage;


    public abstract String getDescription();

    public Size getSize() {
        return beverage.getSize();
    }
}
