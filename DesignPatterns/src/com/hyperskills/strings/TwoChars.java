package com.hyperskills.strings;

import java.util.Scanner;

public class TwoChars {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String string = scn.nextLine();
        String[] arr = string.split(" ");
        String base = arr[0];
        char first = arr[1].charAt(0);
        char second = arr[2].charAt(0);
        int count = 0;
        for (int i = base.length() - 1; i > 0; i--) {


            if (base.charAt(i) == first && base.charAt(i-1) == second
            || base.charAt(i) == second && base.charAt(i-1) == first ) {
                count++;
            }
        }
        System.out.println(count);
    }
}
