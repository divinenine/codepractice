package fundamentals;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static fundamentals.Apple.*;
import static fundamentals.Apple.Color.*;

public class Main {


    public static class AppleHeavyWeightPredicate implements ApplePredicate {

        @Override
        public boolean test(Apple apple) {
            return apple.getWeight() > 150;
        }
    }

    public static class AppleGreenColorPredicate implements ApplePredicate {

        @Override
        public boolean test(Apple apple) {
            return GREEN.equals(apple.getColor());
        }
    }

    public static class AppleFancyFormatter implements AppleFormatter {


     @Override
        public String accept(Apple a) {
         String characteristic = a.getWeight() > 150 ? "heavy" : "light";
         return "A " + characteristic + " " + a.getColor() + " apple";
     }
    }

    public static class AppleSimpleFormatter implements AppleFormatter {
        public String accept(Apple apple) {
            return "An apple of " + apple.getWeight() +"g";
        }
    }

    public static void prettyPrintApple (List<Apple> inventory, AppleFormatter f) {
        for (Apple apple : inventory) {
            String output = f.accept(apple);
            System.out.println(output);
        }
    }





        //without parametrization
/*    public static List<Apple> filterGreenApples(List<Apple> inventory) {
            List<Apple> result = new ArrayList<>();
            for (Apple apple : inventory) {
                if (GREEN.equals(apple.getColor())) {
                    result.add(apple);
                }

            }
            return result;
    }*/

        //with parametrization
   public static List<Apple> filterGreenApples(List<Apple> inventory, Color color) {
            List<Apple> result = new ArrayList<>();
            for (Apple apple : inventory) {
                if (apple.getColor().equals(color)) {
                    result.add(apple);
                }

            }
            return result;
    }
        //breaks Don't repeat yourself principle
    public static List<Apple> filterApplesByWeight (List<Apple> inventory, int weight) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (apple.getWeight() > weight) {
                result.add(apple);
            }

        }
        return result;

    }

    public static List<Apple> filterApples (List<Apple> inventory, ApplePredicate p) {
       List<Apple> result = new ArrayList<>();
       for (Apple apple : inventory) {
           if (p.test(apple)) {
                result.add(apple);
           }
       }
       return result;


    }





    public static void main(String[] args) {

        List<Apple> inventory = new ArrayList<>();

        Apple greenApple01 = new Apple(GREEN, 105);
        Apple greenApple02 = new Apple(GREEN, 204);
        Apple greenApple03 = new Apple(GREEN,142);
        Apple greenApple04 = new Apple(GREEN, 220);

        Apple redApple01 = new Apple(RED,160);
        Apple redApple02 = new Apple(RED, 119);
        Apple redApple03 = new Apple(RED, 153);
        Apple redApple04 = new Apple(RED, 144);


        inventory.add(greenApple01);
        inventory.add(redApple04);
        inventory.add(greenApple02);
        inventory.add(greenApple03);
        inventory.add(redApple02);
        inventory.add(greenApple04);
        inventory.add(redApple03);
        inventory.add(redApple01);

        System.out.println(inventory);

        //List<Apple> greenApples = filterGreenApples(inventory, GREEN);
        //List<Apple> redApples = filterGreenApples(inventory, RED);

        //List<Apple> over150g = filterApplesByWeight(inventory, 150);


        //AppleGreenColorPredicate greenColorPredicate = new AppleGreenColorPredicate();
        //AppleHeavyWeightPredicate heavyWeightPredicate = new AppleHeavyWeightPredicate();

        /*List<Apple> greenApples = filterApples(inventory, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return GREEN.equals(apple.getColor());
            }
        });*/

        List<Apple> greenApples = filterApples(inventory, (Apple a) -> GREEN.equals(a.getColor()));
        List<Apple> heavyApples = filterApples(inventory, new AppleHeavyWeightPredicate());

        List<Apple> redApples = filterApples(inventory, (Apple apple) -> RED.equals(apple.getColor()));
        System.out.println(greenApples);

       // System.out.println(heavyApples);

        //without lambda
/*        Comparator<Apple> byWeight = new Comparator<Apple>() {
            @Override
            public int compare(Apple a1, Apple a2) {
                return a1.getWeight().compareTo(a2.getWeight());
            }
        };*/

        Comparator<Apple> byWeight = (Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight());

        redApples.sort(byWeight);

       // System.out.println(redApples);

        //prettyPrintApple(inventory, new AppleSimpleFormatter());
    }




}
