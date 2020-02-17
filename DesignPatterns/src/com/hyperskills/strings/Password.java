package com.hyperskills.strings;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Password {

    //The password is hard to crack if it contains at least A uppercase letters,
    // at least B lowercase letters, at least C digits and includes exactly N symbols.
    // Also, a password cannot contain two or more same characters coming one after another.
    // For a given numbers A, B, C, N you should output password that matches these requirements.

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int A = scn.nextInt();
        int B = scn.nextInt();
        int C = scn.nextInt();
        int N = scn.nextInt();

        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        ArrayList<Character> charList = new ArrayList<>();

        for (char c : alphabet) {
            charList.add(c);
        }

        char[] alphabetUpper = "abcdefghijklmnopqrstuvwxyz".toUpperCase().toCharArray();

        ArrayList<Character> charListUpper = new ArrayList<>();

        for (char c : alphabetUpper) {
            charListUpper.add(c);
        }

        ArrayList<Integer> intList = new ArrayList<>();
        intList.add(0);
        intList.add(1);
        intList.add(2);
        intList.add(3);
        intList.add(4);
        intList.add(5);
        intList.add(6);
        intList.add(7);
        intList.add(8);
        intList.add(9);
        Random rand = new Random();
        String pass = "";
        while (pass.length() < N) {

            for (int i = 0; i < A; i++) {
                if (pass.length() == N) {
                    break;
                }
                if (!charListUpper.isEmpty()) {
                    int randInt = rand.nextInt(charListUpper.size());
                    pass += charListUpper.get(randInt);
                    //  charListUpper.remove(randInt);
                }


            }

            for (int j = 0; j < B; j++) {
                if (pass.length() == N) {
                    break;
                }
                if (!charList.isEmpty()) {
                    int randInt = rand.nextInt(charList.size());
                    pass += charList.get(randInt);
                    // charList.remove(randInt);
                }

            }

            for (int k = 0; k < C; k++) {
                if (pass.length() == N) {
                    break;
                }
                if (!intList.isEmpty()) {
                    int randInt = rand.nextInt(intList.size());
                    pass += intList.get(randInt);
                    // intList.remove(randInt);
                }

            }

        }
        String passRefined = "";
        char currentChar = 'a';
        char nextChar = 'b';

         if (pass.length() > 1) {
             for (int i = pass.length() - 1; i > 0; i--) {
                 currentChar = pass.charAt(i);
                 nextChar = pass.charAt(i - 1);
                 if (passRefined.isEmpty()) {
                     passRefined += currentChar;
                 } else {
                     while (currentChar == nextChar) {

                         currentChar = pass.charAt(rand.nextInt(pass.length()));
                     }
                     passRefined += currentChar;
                 }

                 if (i == 1) {
                     nextChar = pass.charAt(i - 1);
                     passRefined += nextChar;
                 }

             }
         } else {
             passRefined = pass;
         }

        System.out.println(pass);
        System.out.println(passRefined);
    }
}
