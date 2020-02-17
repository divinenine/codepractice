package com.ocp.chapter1;

public class Main {

    public static void main(String[] args) {


        HeavyAnimal hippo = new Hippo();
        boolean b1 = hippo instanceof Hippo; //true
        boolean b2 = hippo instanceof HeavyAnimal; //true
        boolean b3 = hippo instanceof Elephant; //false
        boolean b4 = hippo instanceof Object; //true
        Hippo nullHippo = null;
        boolean b5 = nullHippo instanceof Object; //false
        Hippo anotherHippo = new Hippo();
       // boolean b6 = anotherHippo instanceof Elephant; //DOES NOT COMPILE
        boolean b7 = hippo instanceof Mother; //COMPILES, COULD BE IMPLEMENTED IN RUNTIME

        Animal animal = new Lion(5, 10, "John");
        Animal animal2 = new Lion(5, 14, "Harry");
        System.out.println(animal.equals(animal2));
        System.out.println(animal.name);
        animal.printName();
        animal.careFor(); // looks for overridden methods in subclasses

    }

    public void feedAnimal (Animal animal) {
        animal.feed();
    }


    static abstract class Animal {
        public void careFor() {
            play();
        }
        public void play() {
            System.out.println("pet animal");
        }
        String name = "???";
        public abstract void feed();
        public void printName() {
            System.out.println(name);
        }
    }


    static class Cow extends Animal {


        @Override
        public void feed() {
            addHay();
        }

        private void addHay(){}
    }


    static class Bird extends Animal {

        @Override
        public void feed() {
            addSeed();
        }

        private void addSeed(){}
    }

    static class Lion extends Animal {
        private int idNumber;
        private int age;
        private String name = "Leo";

        public Lion(int idNumber, int age, String name) {
            this.idNumber = idNumber;
            this.age = age;
            this.name = name;
        }

        @Override public boolean equals (Object obj) {
            if (!(obj instanceof Lion) ) return false;
            Lion otherLion = (Lion) obj;
            return this.idNumber == otherLion.idNumber;

        }
        @Override
        public void play() {
            System.out.println("toss in meat");
        }
        @Override
        public void feed() {
            addMeat();
        }

        private void addMeat(){}
    }



    public interface Mother {}


    static class HeavyAnimal {

    }

    static class Hippo extends HeavyAnimal {

    }

    static class Elephant extends HeavyAnimal {


    }

}
