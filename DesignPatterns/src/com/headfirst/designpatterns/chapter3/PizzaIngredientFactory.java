package com.headfirst.designpatterns.chapter3;

public interface PizzaIngredientFactory {

    public abstract Dough createDough();
    public Sauce createSauce();
    public Cheese createCheese();
    public Veggies[] createVeggies();
    public Pepperoni createPepperoni();
    public Clam createClam();

}
