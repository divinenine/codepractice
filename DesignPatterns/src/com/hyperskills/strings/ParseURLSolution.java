package com.hyperskills.strings;
import java.util.*;

class ParseURLSolution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        String parameters = line.split("\\?")[1];

        for (String items : parameters.split("&")) {
            if (items.split("=").length == 2) {
                System.out.println(items.replaceAll("=", " : "));
            } else {
                System.out.println(items.replaceAll("=", " : ") + "not found");
            }
        }

        if (parameters.contains("pass")) {
            for (String items : parameters.split("&")) {
                String[] temp = items.split("=");
                if (temp[0].equals("pass")) {
                    System.out.println("password : " + temp[1]);
                }
            }
        }
    }
}