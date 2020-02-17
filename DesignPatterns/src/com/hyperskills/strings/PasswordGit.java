package com.hyperskills.strings;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class PasswordGit {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();//upper
        int b = sc.nextInt();//lower
        int c = sc.nextInt();//digits
        int n = sc.nextInt();//
        int bonus = 0;



        Set<Character> set = new HashSet<>();

        for (int i = 0; i < a; i++) {
            set.add(Character.toUpperCase(createRandomSybmbol()));
        }
        for (int i = 0; i < b; i++) {
            set.add(Character.toLowerCase(createRandomSybmbol()));
        }
        for (int i = 0; i < c; i++) {
            set.add(Character.forDigit(new Random().nextInt(10) , 10));

        }



        StringBuilder builder= new StringBuilder();

        if (n > a+b+c) {
            bonus = n - (a+b+c);
            n = a+b+c;
        } else {
            n = n;
        }

        for(int i = 0; i < n; i++){
            builder.append(set.toArray()[i]);
        }

        if (n != 1) {
            for (int j = 0; j < bonus; j++) {
                builder.append(set.toArray()[j]);
            }
        } else {
            builder.append(createRandomSybmbol());
        }


        System.out.println(builder.toString());



    }

    public static Character createRandomSybmbol() {
        return (char) (new Random().nextInt(26) + 'a');
    }
}
