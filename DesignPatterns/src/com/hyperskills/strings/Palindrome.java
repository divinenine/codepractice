package com.hyperskills.strings;

import java.util.Scanner;

public class Palindrome {

    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        String check = scanner.nextLine();

        String rtl = "";

        for (int i = check.length() - 1; i >= 0; i--) {
            char ch = check.charAt(i);
            rtl += ch;
        }

        if (rtl.equals(check)) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}
