package com.headfirst.designpatterns.chapter2;

public class StarbuzzCoffee {

    public static void main(String[] args) {
        Beverage beverage = new Espresso();
        System.out.println(beverage.getDescription() + " $" + beverage.cost());
        Beverage beverage2 = new HouseBlend();
        beverage2.setSize(Beverage.Size.GRANDE);
        System.out.println(beverage2.cost());
        System.out.println(beverage2.getSize());
        beverage2 = new Soy(beverage2);
        System.out.println(beverage2.cost());
       // System.out.println(beverage2.getSize());
        beverage2 = new Mocha(beverage2);
        System.out.println(beverage2.cost());
     //   System.out.println(beverage2.getSize());
        beverage2 = new Whip(beverage2);

        System.out.println(beverage2.getDescription() + " $" + beverage2.cost());

    }
}
