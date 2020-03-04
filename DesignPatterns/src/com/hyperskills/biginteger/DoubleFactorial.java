package com.hyperskills.biginteger;

import edu.princeton.cs.algs4.In;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class DoubleFactorial {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        BigInteger one = BigInteger.ONE;
        ArrayList<Integer> arrayNum = new ArrayList<>();

        for (int i = number; i > 0; i-=2) {

            arrayNum.add(i);
        }
        for (int i : arrayNum) {

          one =  one.multiply(new BigInteger(String.valueOf(i)));

        }

        System.out.println(one);

    }

}
