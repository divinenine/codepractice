package com.hyperskills.strings;

import java.util.*;

public class CompressionAlgo {


    static List<String> list = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String dna = sc.nextLine();

        StringBuilder dnaNew = new StringBuilder();

        char currchar = 'a';

        int counter = 1;

        for (int i = 0; i < dna.length(); i++ ) {

            if (i > 0) {

                char nextchar = dna.charAt(i);

                if (nextchar == currchar) {
                    counter++;
                } else {

                    list.add(Character.toString(currchar));
                    list.add(String.valueOf(counter));
                    counter = 1;
                }

                currchar = dna.charAt(i);
                if (i == dna.length() - 1) {
                    list.add(Character.toString(currchar));
                    list.add(String.valueOf(counter));
                }
            } else if (dna.length() == 1) {
                currchar = dna.charAt(i);
                list.add(Character.toString(currchar));
                list.add(String.valueOf(counter));
            } else {
                currchar = dna.charAt(i);
            }
        }


        for (String s : list) {
            dnaNew.append(s);
        }

        System.out.println(dnaNew);
    }

}
