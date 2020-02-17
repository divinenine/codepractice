package com.headfirst.designpatterns.chapter3;

public class CheesePizza extends Pizza {

    PizzaIngredientFactory ingredientFactory;

    public CheesePizza(PizzaIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }

    @Override
    void prepare() {
        System.out.println("Preparing " + name);
        System.out.println("Adding dough for cheese pizza from factory");
        dough = ingredientFactory.createDough();
        System.out.println("Adding sauce for cheese pizza from factory");
        sauce = ingredientFactory.createSauce();
        System.out.println("Adding cheese for cheese pizza from factory");
        cheese = ingredientFactory.createCheese();
    }
}
