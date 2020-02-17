package com.headfirst.designpatterns.chapter2;

public class HouseBlend extends Beverage {

    public HouseBlend() {
        description = "House Blend Coffee";

    }

    @Override
    public double cost() {
        return .89;
    }
}
