package com.hyperskills.multiarrays;

import java.util.Arrays;
import java.util.Scanner;

public class FillTheMatrix {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int length = scn.nextInt();
        int [][] matrix = new int[length][length];
        int current = 0;
        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = current;
                if (j < i) {
                    current--;
                } else {
                    current++;
                }
            }
            current = i+1;
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int k = 0; k < matrix[i].length; k++) {
                if (k == matrix[i].length - 1) {
                    System.out.print(matrix[i][k]);
                    break;
                }
                System.out.print(matrix[i][k] + " ");

            }
            System.out.println();
        }

    }

}
