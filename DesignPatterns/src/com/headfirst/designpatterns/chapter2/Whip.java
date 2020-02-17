package com.headfirst.designpatterns.chapter2;

public class Whip extends CondimentDecorator {


    public Whip(Beverage beverage) {
        this.beverage = beverage;
    }


    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Whip";

    }

    @Override
    public double cost() {

        double cost = beverage.cost();

        switch (beverage.getSize()) {

            case TALL:
                cost += .10;
                break;
            case VENTI:
                cost += .15;
                break;
            case GRANDE:
                cost += .20;
                break;
            default:
                System.out.println("Unknown size");
                return 0;
        }
        return cost;
    }
}

