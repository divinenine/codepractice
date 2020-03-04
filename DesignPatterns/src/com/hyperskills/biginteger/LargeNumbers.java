package com.hyperskills.biginteger;

import java.math.BigInteger;
import java.util.Scanner;

public class LargeNumbers {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BigInteger zero = BigInteger.ZERO;

        String fourBigInts = sc.nextLine();
        String[] fourInArray = fourBigInts.split(" ");

     //   System.out.println(zero);
            zero = zero.add(new BigInteger(fourInArray[0])).abs();
      //  System.out.println(zero);
            zero = zero.multiply(new BigInteger(fourInArray[1]));
     //   System.out.println(zero);
            zero = zero.add(new BigInteger(fourInArray[2]));
       //     System.out.println(zero);
            zero = zero.subtract(new BigInteger(fourInArray[3]));
        System.out.println(zero);

    }



}
