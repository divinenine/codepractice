package com.hyperskills.inits;

public class Main {

    public static void main(String[] args) {

        MagicNumber[] numbers = new MagicNumber[8];

        for (int i = 0; i < numbers.length; i++) {
            MagicNumber magicNumber = new MagicNumber(i);
        }
    }
}
